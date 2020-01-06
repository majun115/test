package com.majun.Spring.aop;

import org.springframework.stereotype.Service;

@Service
public class OrderInterfaceImp implements OrderInterface{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public Integer delete() {
        System.out.println("delete");
        return 1;
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void find() {
       int a =  1/0;
        System.out.println("find");
    }

    @Override
    public void batch() {
        System.out.println("batch");
    }
}
