package com.myTraining.core.services;


import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = CustomServiceInt.class,
        immediate = true,
        property = {
                Constants.SERVICE_ID + "=Custom Service",
                Constants.SERVICE_DESCRIPTION + "=This service reads values from Configurations"
        })
@Designate(ocd = CustomConfig.class)
 public class CustomServices  implements CustomServiceInt {

   // private static final String TAG = CardServiceImpl.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomServices.class);

    private CustomConfig configuration;

    @Activate
    protected void activate(CustomConfig configuration) {
        LOGGER.info("-------------inside Activate Method--------");
        this.configuration = configuration;
    }

    @Override
    public String getAuthorId() {
        return configuration.getAuthorId();
    }

    @Override
    public String getAuthorApi() {
        return configuration.getAuthorApi();
    }

    @Override
    public String getUserName() {
        return configuration.getUserName();
    }

    @Override
    public String getUserPassword() {
        return configuration.getUserPassword();
    }
}