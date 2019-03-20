package com.example.chapter3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//java配置文件的符号，spring会跟局它来生成IOC容器去装配Bean
@Configuration
//被springioc容器扫描装配 @component标明的类，属性里的"user"是这个bean的名字
//可以使用@Value方法设置值，不需要再像下面一样；
// 注意：如果没有配置basePackages属性或者路径，这里只会扫描AppConfig所属包及子包
@ComponentScan(basePackages = {"com.example.chapter3.*"})
@ImportResource(value = {"classpath:spring-other.xml"})
public class AppConfig {


}
