package com.myTraining.core.services;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        service = SimpleInt.class)
public class SimpleService implements SimpleInt {
    @Reference
    CustomServiceInt cs;
    @Override
    public String getHelloWorld() {

        return "This is simple hello world from simple service"+cs.getUserName();
    }
}
