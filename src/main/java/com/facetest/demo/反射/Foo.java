package com.facetest.demo.反射;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Foo{
  String[] value();
  boolean bar();
}