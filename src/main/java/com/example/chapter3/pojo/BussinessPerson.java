package com.example.chapter3.pojo;

import com.example.chapter3.pojo.definitioin.Animal;
import com.example.chapter3.pojo.definitioin.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BussinessPerson implements Person{
    //这个注解是通过类型注入BusinessPerson实例中，如果有多个Animal（一种类型有多个）
    //会根据其属性名称和Bean 的名称进行匹配，匹配的上，就使用这个Bean,匹配不上，就不使用
    //是一个默认必须找到对应bean的注解，如果不确定是否存在对应的Bean，可以把required属性置为false
    //这个注解也可以标注方法
    //@Autowired
    //@Qualifier("dog")
    /**这注解用于当@Primary有多个、无法处理歧义的时候
     * 这个注解和@Autowired注解一起使用，相当于用类型和名称一起找到对应的Bean，找到并注入*/
    private Animal animal = null;
    @Value("#{''}")
    private String name;
    public String getName() {
        return name;
    }

    //@Autowired
    //private Animal dog= null;
    @Override
    public void service() {
        this.animal.use();
        //this.dog.use();

    }

    @Override
    @Autowired  @Qualifier("dog")
    public void setAnimal(Animal animal) {
        this.animal = animal;
       // this.dog = animal;

    }

/**也可以在构造方法上下手，直接在参数里使用@AutoWired 和 @Qualifier*/
    /*public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }*/
}
