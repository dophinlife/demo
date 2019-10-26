package com.guangp.demo.spi.provider;

import com.guangp.demo.spi.api.IHelloService;

public class AmericaHelloServiceImpl implements IHelloService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
