package com.ticket.seckill.validator;

import com.ticket.seckill.utils.ValidatorUtil;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * 验证手机号
 *
 * @Author: Shawn Chen
 * @Date: 2023/7/29
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {
                IsMobileValidator.class
        }
)
public @interface IsMobile {

    boolean required() default true;

    String message() default "手机号码格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}