/**
 *
 */
package com.dzr.framework.constant;

/**
 * @author lichao
 */
public interface Constants {

    /**
     * 系统常量
     */
    public interface System {

        public static final String OK = "1";
        public static final String FAIL = "0";

        public static final String SERVER_SUCCESS = "000000";
        public static final String SERVER_SUCCESS_MSG = "服务正常!";

        public static final String SESSION_TIMEOUT = "1000000";
        public static final String SESSION_TIMEOUT_MSG = "登陆超时!";

        public static final String PARAMS_INVALID = "1000001";
        public static final String PARAMS_INVALID_MSG = "参数无效!";

        public static final String PERMISSION_DENIED = "1000002";
        public static final String PERMISSION_DENIED_MSG = "权限不足!";

        public static final String CONNECTION_TIME_OUT = "1000005";
        public static final String CONNECTION_TIME_OUT_MSG = "连接服务超时!";

        public static final String NO_REQUEST_MATCH = "1000006";
        public static final String NO_REQUEST_MATCH_MSG = "没有找到资源!";

        public static final String SYSTEM_ERROR_CODE = "1000007";
        public static final String SYSTEM_ERROR_MSG = "系统错误，请联系管理员!";

        public static final String NO_PERMISSIONS = "1000008";
        public static final String NO_PERMISSIONS_MSG = "没有权限!";
        
        public static final String OPERATE_TIME_OUT = "1000009";
        public static final String OPERATE_TIME_OUT_MSG = "操作超时";
        
    }


}
