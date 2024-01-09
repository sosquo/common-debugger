package com.llz.springtest.demos.refresh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.Properties;

/**
 * 1、准备系统环境
 * 系统环境 JAVA_HOME、Path、MAVEN_HOME、USERNAME
 * 系统属性 java.version、java.home、user.dir、line.separator、java.library.path、java.class.version、file.encoding
 * 配置文件 properties、yml文件
 */
@SpringBootTest(value = "com.llz.springtest.SpringTestApplication")
public class PrepareRefreshTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void testEnvironment() {
        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
        System.out.println("getenv = " + getenv);
        System.out.println("properties = " + properties);
        String property = context.getEnvironment().getProperty("body.pants.color");
        System.out.println("property = " + property);
    }


}
