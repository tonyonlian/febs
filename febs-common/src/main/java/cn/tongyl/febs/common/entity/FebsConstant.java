package cn.tongyl.febs.common.entity;

/**
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
public class FebsConstant {

    private FebsConstant() {

    }

    /**
     * Zuul请求头Token的名称
     */
    public static final String ZUUL_TOKEN_HEADER = "ZuulToken";
    /**
     * Zuul请求头Token的值
     */
    public static final String ZUUL_TOKEN_VALUE = "febs:zuul:123456";
    /**
     * gis 类型
     */
    public static final String GIF = "gif";
    /**
     * png 类型
     */
    public static final String PNG = "png";
    /**
     * 验证码 key 前缀
     */
    public static final String CODE_PREFIX = "febs.captcha";
}

