package com.ilyastuit.book_library_spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.ilyastuit.book_library_spring"})
@EnableAspectJAutoProxy
public class ServletInitializer extends SpringBootServletInitializer {

}
