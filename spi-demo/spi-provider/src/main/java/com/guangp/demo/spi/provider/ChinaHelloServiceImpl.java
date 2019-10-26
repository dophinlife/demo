package com.guangp.demo.spi.provider;

import com.guangp.demo.spi.api.IHelloService;

public class ChinaHelloServiceImpl implements IHelloService {
    public String sayHello(String name) {
        return "你好，" + name;
    }
}
