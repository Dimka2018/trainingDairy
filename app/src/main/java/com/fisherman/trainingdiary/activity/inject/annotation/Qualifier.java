package com.fisherman.trainingdiary.activity.inject.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Qualifier {
    /** The name. */
    String value() default "";
}