package com.example.tiger.mobilelearning.utils;

/**
 * Created by Tiger on 2018/1/5.
 * 接口状态码对照
 */

public class InterfaceStatusCodeUtils {

    private static String resultMsg;

    /**
     * System Level
     */
    // 数据处理成功
    public static final int SYS_SUCCESS_CODE = 0;
    //系统错误
    public static final int SYS_ERROR_CODE = 10001;
    //服务暂停
    public static final int SYS_UNAVAILABLE_CODE = 10005;
    //远程服务错误
    public static final int SYS_REMOTE_ERROR_CODE = 10010;
    //您无权限访问该资源，需请求授权
    public static final int SYS_NO_PERMISSION_CODE = 10015;
    //任务超时
    public static final int SYS_JOB_EXPIRED_CODE = 10020;
    //页面停留时间过长，刷新后重试
    public static final int SYS_STANDING_TIME_CODE = 10021;
    //RPC错误
    public static final int SYS_RPC_ERROR_CODE = 10025;
    //IP请求频次超过上限
    public static final int SYS_IP_LIMIT_CODE = 10030;
    //用户请求频次超过上限
    public static final int SYS_USER_LIMIT_CODE = 10035;
    //尚未登录的用户
    public static final int SYS_NO_LOGIN_CODE = 10040;
    //原因不明的错误
    public static final int SYS_UN_KNOWN_CODE = 10045;
    //请求参数错误
    public static final int SYS_PARAM_ERR_CODE = 10050;
    //数据解析过程出错
    public static final int SYS_DATA_PARSE_ERR_CODE = 10055;
    //${message}不能为空
    public static final int SYS_PARAM_NOT_BLANK_CODE = 10060;
    //没有匹配的数据
    public static final int SYS_NO_DATA_CODE = 10066;
    //系统数据已过期,请重新查询
    public static final int SYS_DATA_EXPIRED_CODE = 10070;
    //${data}已存在
    public static final int SYS_DATA_UNIQUE_CODE = 10080;

    /**
     * Service Level
     */
    //手机号不能为空
    public static final int SMS_MOBILE_BLANK_CODE = 20001;
    //非法手机号
    public static final int SMS_MOBILE_ILLEGAL_CODE = 20005;
    //您的动态密码是：
    public static final int SMS_MOBILE_MSG_PRE_CODE = 20010;
    //，10分钟内有效，请勿泄露给任何人。${data}已存在
    public static final int SMS_MOBILE_MSG_SUF_CODE = 20011;
    //用户名账号不存在
    public static final int SMS_UNFIND_USERNAME_CODE = 30001;
    //登录密码错误
    public static final int SMS_ERRO_PASSWORD_CODE = 30005;

    /**
     * 账号管理 之 登录
     */
    //用户不存在
    public static final int USER_LOGIN_UNKNOWN_USER_CODE = 40000;
    //密码不正确
    public static final int USER_LOGIN_PASSWORD_ERROR_CODE = 40005;
    //用户已锁定
    public static final int USER_LOGIN_LOCKED_USER_CODE = 40010;
    //邮箱/短信验证码错误
    public static final int USER_LOGIN_VERIFY_FAILS_CODE = 40015;

    /**
     * 账号管理 之 注册
     */
    //输入的密码不一致
    public static final int USER_REGISTER_PASSWORD_FAIL_CODE = 40020;
    //手机号已经注册
    public static final int USER_REGISTER_MOBILE_FAIL_CODE = 40025;
    //验证码生成失败
    public static final int USER_VERIFY_MAKE_FAIL_CODE = 40030;
    //验证码生成成功
    public static final int USER_VERIFY_MAKE_SUCCESS_CODE = 40035;

    /**
     * 账号管理 之 修改密码
     */
    //新密码与确认密码不一致
    public static final int USER_PASSWORD_NOT_EQUALS_CODE = 50000;
    //旧密码输入错误
    public static final int USER_PASSWORD_OLD_ERROR_CODE = 50005;
    //新密码与旧密码不能相同
    public static final int USER_PASSWORD_EQUALS_CODE = 50010;
    //验证码有误
    public static final int VERIFY_VALID_ERROR_CODE = 40040;
    //验证码已失效，请重新获取！
    public static final int VERIFY_VALID_EXPIRED_CODE = 40050;

    /**
     *
     * @param resultCode 传过来resultCode来确定时间请求的结果
     * @return
     */
    public static String getResultMsg(int resultCode){
        switch (resultCode){
            /**
             * System Level
             */
            case SYS_SUCCESS_CODE:
                resultMsg = "数据处理成功";
                break;
            case SYS_ERROR_CODE:
                resultMsg = "系统错误";
                break;
            case SYS_UNAVAILABLE_CODE:
                resultMsg = "服务暂停";
                break;
            case SYS_REMOTE_ERROR_CODE:
                resultMsg = "远程服务错误";
                break;
            case SYS_NO_PERMISSION_CODE:
                resultMsg = "您无权限访问该资源，需请求授权";
                break;
            case SYS_JOB_EXPIRED_CODE:
                resultMsg = "任务超时";
                break;
            case SYS_STANDING_TIME_CODE:
                resultMsg = "页面停留时间过长，刷新后重试";
                break;
            case SYS_RPC_ERROR_CODE:
                resultMsg = "RPC错误";
                break;
            case SYS_IP_LIMIT_CODE:
                resultMsg = "IP请求频次超过上限";
                break;
            case SYS_USER_LIMIT_CODE:
                resultMsg = "用户请求频次超过上限";
                break;
            case SYS_NO_LOGIN_CODE:
                resultMsg = "尚未登录的用户";
                break;
            case SYS_UN_KNOWN_CODE:
                resultMsg = "原因不明的错误";
                break;
            case SYS_PARAM_ERR_CODE:
                resultMsg = "请求参数错误";
                break;
            case SYS_DATA_PARSE_ERR_CODE:
                resultMsg = "数据解析过程出错";
                break;
            case SYS_PARAM_NOT_BLANK_CODE:
                resultMsg = "${message}不能为空";
                break;
            case SYS_NO_DATA_CODE:
                resultMsg = "没有匹配的数据";
                break;
            case SYS_DATA_EXPIRED_CODE:
                resultMsg = "系统数据已过期,请重新查询";
                break;
            case SYS_DATA_UNIQUE_CODE:
                resultMsg = "${data}已存在";
                break;
            /**
             * Service Level
             */
            case SMS_MOBILE_BLANK_CODE:
                resultMsg = "手机号不能为空";
                break;
            case SMS_MOBILE_ILLEGAL_CODE:
                resultMsg = "非法手机号";
                break;
            case SMS_MOBILE_MSG_PRE_CODE:
                resultMsg = "您的动态密码是：";
                break;
            case SMS_MOBILE_MSG_SUF_CODE:
                resultMsg = "，10分钟内有效，请勿泄露给任何人。${data}已存在";
                break;
            case SMS_UNFIND_USERNAME_CODE:
                resultMsg = "用户名账号不存在";
                break;
            case SMS_ERRO_PASSWORD_CODE:
                resultMsg = "登录密码错误";
                break;
            /**
             * 账号管理 之 登录
             */
            case USER_LOGIN_UNKNOWN_USER_CODE:
                resultMsg = "用户不存在";
                break;
            case USER_LOGIN_PASSWORD_ERROR_CODE:
                resultMsg = "密码不正确";
                break;
            case USER_LOGIN_LOCKED_USER_CODE:
                resultMsg = "用户已锁定";
                break;
            case USER_LOGIN_VERIFY_FAILS_CODE:
                resultMsg = "邮箱/短信验证码错误";
                break;
            /**
             * 账号管理 之 注册
             */
            case USER_REGISTER_PASSWORD_FAIL_CODE:
                resultMsg = "输入的密码不一致";
                break;
            case USER_REGISTER_MOBILE_FAIL_CODE:
                resultMsg = "手机号已经注册";
                break;
            case USER_VERIFY_MAKE_FAIL_CODE:
                resultMsg = "验证码生成失败";
                break;
            case USER_VERIFY_MAKE_SUCCESS_CODE:
                resultMsg = "验证码生成成功";
                break;
            /**
             * 账号管理 之 修改密码
             */
            case USER_PASSWORD_NOT_EQUALS_CODE:
                resultMsg = "新密码与确认密码不一致";
                break;
            case USER_PASSWORD_OLD_ERROR_CODE:
                resultMsg = "旧密码输入错误";
                break;
            case USER_PASSWORD_EQUALS_CODE:
                resultMsg = "新密码与旧密码不能相同";
                break;
            case VERIFY_VALID_ERROR_CODE:
                resultMsg = "验证码有误";
                break;
            case VERIFY_VALID_EXPIRED_CODE:
                resultMsg = "验证码已失效，请重新获取！";
                break;
        }
        return resultMsg;
    }
}
