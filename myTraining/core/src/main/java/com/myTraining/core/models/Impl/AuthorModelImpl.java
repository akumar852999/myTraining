package com.myTraining.core.models.Impl;

import com.myTraining.core.models.AuthorModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Model(adaptables = Resource.class, adapters = AuthorModel.class)
public class AuthorModelImpl implements AuthorModel {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorModelImpl.class);

    @ValueMapValue
    private String authorName;

    @ValueMapValue
    private String authorBio;

    @ValueMapValue
    private Date dob;

    @ValueMapValue
    private List<String> books;



    public List<String> getBooks() {
        if(books!=null){
            return new ArrayList<String>(books);
        }else{
            return Collections.emptyList();
        }
    }

    @PostConstruct
    protected void init() {
        LOG.info("------------inside Author model init method----------------" + authorName);

    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public Date getDob() {
        return dob;
    }
}
