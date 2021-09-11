package cn.tongyl.febs.common.validator;

import cn.tongyl.febs.common.annotation.IsMobile;
import cn.tongyl.febs.common.entity.RegexpConstant;
import cn.tongyl.febs.common.utils.FebsUtil;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {


    @Override
    public void initialize(IsMobile constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isBlank(value)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return FebsUtil.match(regex, value);
            }
        } catch (Exception e) {
            return false;
        }

    }
}
