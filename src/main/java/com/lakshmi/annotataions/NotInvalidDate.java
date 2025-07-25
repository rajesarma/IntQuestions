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
//@Constraint(validatedBy = DateValidator.class)
public @interface NotInvalidDate {
    int value() default 1900;
    String message() default "Date entered is incorrect (yyyy-mm-dd)";
    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
}
