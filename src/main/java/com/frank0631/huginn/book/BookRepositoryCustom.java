package com.frank0631.huginn.book;


import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface BookRepositoryCustom {
        
    BookEntity giveRandomBook(String title);
        
}