package com.example.chapter3.pojo;

import com.example.chapter3.pojo.definitioin.Animal;
import org.springframework.stereotype.Component;


public class Squirrel implements Animal {
    @Override
    public void use() {
        System.out.println("松鼠采松果");
    }
}
