package com.myTraining.core.services;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Custom Service Configuration", description = "Service Configuration")
public @interface CustomConfig {

    @AttributeDefinition(name = "Author Id", description = "Author id")
    String getAuthorId();

    @AttributeDefinition(name = "Author Api", description = "Author Api")
    String getAuthorApi();

    @AttributeDefinition(name = "UserName", description = "UerName")
    String getUserName();

    @AttributeDefinition(name = "UserPassword", description = "UserPassword")
    String getUserPassword();
}
