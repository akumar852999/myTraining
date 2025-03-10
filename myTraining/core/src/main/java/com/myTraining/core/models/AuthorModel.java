package com.myTraining.core.models;

import java.util.Date;
import java.util.List;

public interface AuthorModel {
    String getAuthorName();
   String getAuthorBio();
    Date getDob();
    String authorImg();
   // String fetchApi();
    List<String> getBooks();
    String getLoadMoreValue();
    String getLoadMoreCtaName();
}