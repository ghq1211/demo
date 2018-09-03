package com.example.demo.common.config;

/**
 * Copyright © 2018青城科技. All rights reserved
 *
 * @Auther: 郭慧乔
 * @Date: 2018/6/7 16:42
 * @Description: 返回状态码 常量
 */
public class StatusCode {

    /**
     * 通用
     */
    public static final Integer CODE_FAILURED= 0;//请求失败
    public static final Integer CODE_SUCCESS = 1;//请求成功
    public static final Integer CODE_REQUEST_PARAMETER = 10; //请求参数为空
    public static final Integer CODE_VERIFICATION_CODE_ERROR = 30;//验证码错误
    public static final Integer CODE_VERIFICATION_CODE_EXPIRED = 40;//验证码已过期
    public static final Integer CODE_SMS_INTERFACE = 50;//短信接口原因问题
    public static final Integer CODE_REPEAT_OPERATION = 60;//重复操作

    /**
     * 注册
     */
    public static final Integer CODE_ACCOUNT_ALREADY_EXISTS = 103; //账号已存在

    /**
     * 登录
     */
    public static final Integer CODE_USER_DOES_NOT_EXIST = 110; //用户不存在
    public static final Integer CODE_ACCOUNT_EXCEPTION = 111; //账号异常
    public static final Integer CODE_WRONG_PASSWORD = 112; //密码错误

    public static final Integer CODE_TOKEN_VERIFICATION_FAILED =  220; // token验证失败

    /**
     * 生成大写
     * @param args
     */
    public static void main(String[] args) {
        String b ="Bank card does not match";
        String c = b.replaceAll(" ","_");
        System.out.println("public static final Integer CODE_"+c.toUpperCase()+" = ");
    }

}
