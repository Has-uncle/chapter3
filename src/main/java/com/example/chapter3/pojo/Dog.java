package com.example.chapter3.pojo;

import com.example.chapter3.pojo.definitioin.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("The dog is seeing the 门");
    }
}
