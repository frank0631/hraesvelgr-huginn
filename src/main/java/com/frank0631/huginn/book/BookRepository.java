package com.frank0631.huginn.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by frank0631 on 5/12/15.
 */
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends CrudRepository<BookEntity, Long>, BookRepositoryCustom {

    List<BookEntity> findByTitle(@Param("title")String title);
}
