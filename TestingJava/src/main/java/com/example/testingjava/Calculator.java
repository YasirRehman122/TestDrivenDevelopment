package com.example.testingjava;

public class Calculator {

    User user = new User("John");
    public Calculator(){
        System.out.println("New calculator created : " + this) ;
    }
    public Integer integerDivision(Integer dividend, Integer divisor){
        return dividend/divisor;
    }
}
