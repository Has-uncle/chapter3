package com.example.chapter3.pojo;

import com.example.chapter3.pojo.definitioin.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//这个注解用于消除歧义，当@Autowired注解碰到多个类型时，可以不用修改对应的属性名字，按照名字找到bean
//使用这个方法就是：修改优先权。如果有两个同样类型的bean,要使用哪一个，就在哪一个类前加入这个注解
//意思是高诉Ioc容器“优先使用我注入”
//@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("The cat is 'miaomiao'");
    }
}
