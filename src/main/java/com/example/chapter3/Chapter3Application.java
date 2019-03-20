package com.example.chapter3;

import com.example.chapter3.config.AppConfig;
import com.example.chapter3.pojo.BussinessPerson;
import com.example.chapter3.pojo.ScopeBean;
import com.example.chapter3.pojo.Squirrel;
import com.example.chapter3.pojo.definitioin.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound = true)
public class Chapter3Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        /*Person person = ctx.getBean(BussinessPerson.class);
        person.service();*/
        /*ScopeBean scopeBean = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        System.out.println(scopeBean.equals(scopeBean1));*/
        /*Squirrel squirrel = ctx.getBean(Squirrel.class);
        squirrel.use();*/
        Person person = ctx.getBean(BussinessPerson.class);
        System.out.println(person.getName());


    }

}
