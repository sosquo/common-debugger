package com.llz.springtest.demos.config;

import com.llz.springtest.demos.bean.MyStudentBean;
import com.llz.springtest.demos.bean.MyTeacherBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {

    @Bean
    public MyStudentBean studentBean() {
        return new MyStudentBean(12580, "大聪明");
    }

    @Bean
    public MyTeacherBean MyTeacherBean() {
        return new MyTeacherBean(110, "大表哥");
    }
}
