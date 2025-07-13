package com.lakshmi.annotataions;



//import javax.validation.Constraint;
//import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = CategoryValidator.class)
public @interface NotInvalidValue {
//    String value() default Constants.BLANK_STRING;
    String message() default "Invalid Value";
    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
}
