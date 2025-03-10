package com.myTraining.core.workflow;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = WorkflowProcess.class,
        property = {
                "process.label=Custom Workflow Process"
        }
)
public class CustomWorkflowProcess implements WorkflowProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) {
        LOGGER.info("[Custom Workflow] Executing workflow process...");

        if (workItem == null || workItem.getWorkflowData() == null) {
            LOGGER.error(" [Custom Workflow] WorkItem or WorkflowData is NULL!");
            return;
        }

        String payloadPath = workItem.getWorkflowData().getPayload().toString();
        LOGGER.info("[Custom Workflow] Payload Path: {}", payloadPath);
    }
}
