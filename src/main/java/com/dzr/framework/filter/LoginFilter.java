package com.dzr.framework.filter;

import com.alibaba.fastjson.JSONObject;

import com.dzr.framework.constant.Constants;
import com.dzr.framework.constant.enums.PermissionResult;
import com.dzr.framework.context.ContextUtils;
import com.dzr.framework.pojo.dto.ResponseEntity;
import com.dzr.framework.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登陆检测过滤器
 * <p style="display:none">
 * modifyRecord
 * </p>
 *
 * @author QiuYangjun
 * @date 2014-5-7 上午10:58:58
 */
public class LoginFilter implements Filter {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private LoginService loginService;


    /**
     * @param filterConfig
     * @throws javax.servlet.ServletException
     * @author QiuYangjun
     * @date 2014-5-7 上午10:58:59
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * <p>
     * session中检测是否登陆,如果没有检测是否有cookie,如果有cookie重建登陆信息
     * </p>
     *
     * @param chain
     * @throws IOException
     * @throws javax.servlet.ServletException
     * @author QiuYangjun
     * @date 2014-5-7 上午10:58:59
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        // 如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中无法得到的方法，就要把此request对象构造成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();

        loginService = (LoginService) ContextUtils.getBean(LoginService.class);
        PermissionResult result = null;
        try {
            result = loginService.checkPermission(request);
        } catch (Exception e) {
            result = PermissionResult.SESSION_TIMEOUT;
            logger.error(e.getMessage(), e);
        }
        switch (result) {
            case PERMISSION_SUCCESS:
                chain.doFilter(servletRequest, servletResponse);
                break;
            case PERMISSION_DENIED:
                response.getOutputStream().println(getPermissionResultEntity());
                break;
            case SESSION_TIMEOUT:
                response.getOutputStream().println(getTimeoutResultEntity());
                break;
            default:
                break;
        }


    }

    private String getPermissionResultEntity() {
        ResponseEntity ret = new ResponseEntity();
        ret.setStatus(Constants.System.FAIL);
        ret.setError(Constants.System.PERMISSION_DENIED);
        ret.setMsg("permission denied");

        return JSONObject.toJSON(ret).toString();
    }


    protected String getTimeoutResultEntity() {
        ResponseEntity ret = new ResponseEntity();
        ret.setStatus(Constants.System.FAIL);
        ret.setError(Constants.System.SESSION_TIMEOUT);
        ret.setMsg("session timeout");

        return JSONObject.toJSON(ret).toString();
    }

    /**
     * @author QiuYangjun
     * @date 2014-5-7 上午10:58:59
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
