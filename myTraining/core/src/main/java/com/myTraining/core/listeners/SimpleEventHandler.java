/*
package com.myTraining.core.listeners;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Component(
        service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
                EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
                EventConstants.EVENT_FILTER + "=(path=/content/myTraining/us/*)"
        }
)
public class SimpleEventHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEventHandler.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(Event event) {
        LOGGER.info("--------------Event Received: {}", event.getTopic());

        String resourcePath = (String) event.getProperty("path");
        LOGGER.info("--------------Resource Affected: {}", resourcePath);

        try (ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(null)) {
            Session session = resourceResolver.adaptTo(Session.class);
            if (session != null && session.nodeExists(resourcePath)) {
                Node node = session.getNode(resourcePath);
                LOGGER.info("--------------Node Type: {}", node.getPrimaryNodeType().getName());
            }
        } catch (RepositoryException e) {
            LOGGER.error("--------------Error accessing JCR Node: ", e);
        } catch (Exception e) {
            LOGGER.error("--------------Error in Event Handler: ", e);
        }
    }
}
*/
