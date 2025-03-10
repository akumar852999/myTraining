/*
package com.myTraining.core.listeners;

import org.apache.sling.api.resource.observation.ResourceChange;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component(
        service = ResourceChangeListener.class,
        property = {
                ResourceChangeListener.PATHS + "=/content/myTraining/us",
                ResourceChangeListener.CHANGES + "=ADDED",
                ResourceChangeListener.CHANGES + "=CHANGED"
        }
)
public class SimpleEventListener implements ResourceChangeListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEventListener.class);

    @Override
    public void onChange(List<ResourceChange> changes) {
        for (ResourceChange change : changes) {
            LOGGER.info("--------------Event detected: {} on path: {}", change.getType(), change.getPath());
        }
    }
}
*/
