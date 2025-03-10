package com.myTraining.core.schedulers;

import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

@Component(service = Runnable.class, immediate = true, property = {
        "scheduler.expression=0 0/1 * * * ?", // Runs every 1 minute
        "scheduler.concurrent=false",
        "scheduler.name=MySimpleScheduler"
})
public class SimpleScheduler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleScheduler.class);
    private final AtomicInteger executionCount = new AtomicInteger(0);

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate() {
        LOGGER.info("--------SimpleScheduler Activated");
    }

    @Deactivate
    protected void deactivate() {
        LOGGER.info("------------SimpleScheduler Deactivated");
    }

    @Override
    public void run() {
        int count = executionCount.incrementAndGet();
        LOGGER.info("---------SimpleScheduler executed {} times", count);
    }
}
