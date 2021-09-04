package cn.tongyl.febs.common.exception;

/**
 * @author create by Tunyl on 2021/9/4
 * @version 1.0
 */
public class ValidateCodeException extends Exception{
    private static final long serialVersionUID = 7575777557775757L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
