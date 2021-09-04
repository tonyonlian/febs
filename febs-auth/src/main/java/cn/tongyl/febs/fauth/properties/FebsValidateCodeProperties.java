package cn.tongyl.febs.fauth.properties;

import lombok.Data;

/**
 * @author create by Tunyl on 2021/9/4
 * @version 1.0
 */
@Data
public class FebsValidateCodeProperties {
    /**
     * 验证码的有效时间，单位秒
     */
    private Long time = 120L;
    /**
     * 验证码的类型，可选值png和gif
     */
    private String type = "png";
    /**
     * 国片宽度，px
     */
    private Integer width = 130;
    /**
     * 验证码的位数
     */
    private Integer height = 48;
    /**
     * 验证码值的类型
     * 1.数字加字母
     * 2.纯数字
     * 3.纯字母
     */
    private Integer length = 4;

    private Integer charType = 2;
}
