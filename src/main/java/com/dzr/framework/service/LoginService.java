package com.dzr.framework.service;



import com.dzr.framework.constant.enums.PermissionResult;
import com.dzr.framework.dto.LoginResponse;
import com.dzr.framework.dto.LoginUserDto;
import com.dzr.framework.exception.DataCommitException;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

    LoginUserDto userLoginSuccess(LoginUserDto user, String token, String loginIp, HttpServletRequest request, HttpServletResponse response) throws DataCommitException;

    @Transactional(readOnly = false)
    boolean userLoginSuccess(LoginUserDto user, HttpServletRequest request, HttpServletResponse response);

    /**
     * 过滤器检查用户登陆情况和权限
     * @param request
     * @return
     */
    public PermissionResult checkPermission(HttpServletRequest request);


    /**
     * <p>用户登录</p>
     * @author QiuYangjun
     * @date 2014-5-6 下午4:04:47
     * @param loginName
     * @param password
     * @param loginIp
     * @return
     * @see
     */
    public LoginResponse login(String loginName, String password, String loginIp, HttpServletRequest request, HttpServletResponse response) throws DataCommitException;

    /**
     * 用户登出
     * @param userId
     * @param loginIp
     */
    public void logout(String userId, String loginIp) throws DataCommitException;

}
