package com.guangp.demo.spi.consumer;

import com.guangp.demo.spi.api.IHelloService;

import java.util.ServiceLoader;

public class HelloServiceTest {
    public static void main(String[] args) {
        ServiceLoader<IHelloService> loader = ServiceLoader.load(IHelloService.class);
        for (IHelloService helloService : loader) {
            System.out.println(helloService.sayHello("GGP"));
        }
    }
}
