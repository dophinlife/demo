package com.guangp.demo.spi.consumer;

import com.guangp.demo.spi.api.IHelloService;

import java.lang.reflect.InvocationTargetException;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

public class HelloServiceTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ServiceLoader<IHelloService> loader = ServiceLoader.load(IHelloService.class);

        Set<IHelloService> sets = loader.stream()
                .filter(p -> p.type().getName().contains("China"))
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toSet());

        for (IHelloService helloService : sets) {
            System.out.println(helloService.sayHello("管广鹏"));
        }

        for (IHelloService helloService : loader) {
            System.out.println(helloService.sayHello("GGP"));
        }

//        var son = new Son();
//        var father = new Father();
//        System.out.println(father.classString());
//        System.out.println(son.classString());
//        System.out.println( Extend.class == Super.class);
        var father = Son.class.getConstructor().newInstance();
        System.out.println(father.classString());
    }

    interface Super {

    }

    interface Extend extends Super {
    }

    public static class Father{
        public Father() {
            System.out.println("construct Father");
        }
        String classString() {
            System.out.println("call father classString()");
            return getClass().toString();
        }
    }

    public static class Son extends Father {
        //public Son(){super();}
        String classString() {
            System.out.println(super.classString());
            return getClass().toString();
        }
    }
}