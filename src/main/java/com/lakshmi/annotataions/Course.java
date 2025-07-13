package com.lakshmi.annotataions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Course {
	String cid() default "c-111";
	String cname() default "C Languge";
	int ccost() default 1000;
}
