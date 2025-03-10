/*
package com.myTraining.core.schedulers;

import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component(service = JobTrigger.class, immediate = true)
public class JobTrigger {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobTrigger.class);

    @Reference
    private JobManager jobManager;

    @Activate
    protected void activate() {
        LOGGER.info("-------Activating JobTrigger - Automatically Triggering Sling Job...");
        triggerJob();
    }

    private void triggerJob() {
        if (jobManager != null) {
            Map<String, Object> jobProps = new HashMap<>();
            jobProps.put("customParam", "TriggeredAutomatically");
            jobManager.addJob("myTraining/job/hello", jobProps);
            LOGGER.info("-------Sling Job Triggered Successfully!");
        } else {
            LOGGER.error("----- JobManager is null. Cannot trigger the job!");
        }
    }
}
*/
