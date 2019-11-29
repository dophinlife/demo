package com.mal.demo.spi.provider;

import com.guangp.demo.spi.api.IHelloService;

public class MaryHelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "Cloud. Hello " + name;
    }
}
