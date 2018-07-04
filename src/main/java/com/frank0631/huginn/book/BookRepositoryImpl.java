package com.frank0631.huginn.book;

import com.frank0631.nidhogg.book.Book;

import org.springframework.core.io.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.*;
import org.springframework.http.*;
import org.springframework.hateoas.*;
import org.springframework.hateoas.mvc.*;

import java.util.Random;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.collections4.IteratorUtils;

@Controller
@ExposesResourceFor(BookEntity.class)
public class BookRepositoryImpl implements BookRepositoryCustom{

    @Autowired private BookRepository bookRepository;

    @Override
    public BookEntity giveRandomBook(final String title) {
        Iterable<BookEntity> books = null;
        if (title != null && !title.isEmpty()) {
            books = bookRepository.findByTitle(title);
            }

        if (books == null || books.spliterator().getExactSizeIfKnown() == 0 ){
            	books = bookRepository.findAll();
        }


        List<BookEntity> bookList = IteratorUtils.toList(books.iterator());

        if (bookList != null && !bookList.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(bookList.size());
            BookEntity randomBook = bookList.get(index);
            return randomBook;
        } else {
            return null;
        }
    }
}

