package com.myTraining.core.models.Impl;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.myTraining.core.models.AuthorModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Optional;

@Model(adaptables = Resource.class, adapters = AuthorModel.class)
public class AuthorModelImpl implements AuthorModel {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorModelImpl.class);

    @ValueMapValue
    private String authorName;

    @ValueMapValue
    private String authorBio;

    @ValueMapValue
    private Date dob;

    @PostConstruct
    protected void init() {
        LOG.info("------------inside Author model init method----------------"+authorName);

    }


    @Override
    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String getBio() {
        return authorBio;
    }

    @Override
    public Date getDOB() {
        return dob;
    }
}