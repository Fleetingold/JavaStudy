package com.mystudy.icbc.request;

import java.lang.annotation.RetentionPolicy;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Target;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
@Inherited
public @interface RequestXMLElement {
	String name();
	String parent() default "";
}
