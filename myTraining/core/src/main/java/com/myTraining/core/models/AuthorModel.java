package com.myTraining.core.models;

import java.util.Date;
import java.util.List;

public interface AuthorModel {
    String getAuthorName();
   String getAuthorBio();
    Date getDob();
    List<String> getBooks();
}