package com.myTraining.core.services;

import org.osgi.service.component.annotations.Component;

@Component(
        service = SimpleInt.class)
public class SimpleService implements SimpleInt {
    @Override
    public String getHelloWorld() {
        return "This is simple hello world from simple service";
    }
}
