package com.dzr.framework.spring.resolver;

import com.alibaba.fastjson.JSONObject;

import com.dzr.framework.constant.Constants;
import com.dzr.framework.pojo.dto.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Package Name: com.sdxd.vip.common.exceptionResolver
 * Description:
 * Author: qiuyangjun
 * Create Date:2015/6/17
 */
@Component
public class GlobalJsonHandlerExceptionResolver extends SimpleMappingExceptionResolver {

    public static Logger logger = LoggerFactory.getLogger(GlobalJsonHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error(ex.getMessage(),ex);
        response.setCharacterEncoding("utf-8");
        ResponseEntity result = new ResponseEntity();
        result.setMsg(Constants.System.SYSTEM_ERROR_MSG);
        result.setError(Constants.System.SYSTEM_ERROR_CODE);
        result.setStatus(Constants.System.FAIL);
        result.setData(ex.getMessage());
//        LOG.warn("Global exception found, Exception is: {}", ex);
        try {
            PrintWriter writer = response.getWriter();
            writer.write(JSONObject.toJSONString(result));
            writer.flush();
        } catch (Exception e) {
            logger.error("Write exception error: {}", e);
        }

        return null;
    }
}
