package com.frank0631.huginn.book;

import com.frank0631.nidhogg.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.collections4.IteratorUtils;


@RestController
@RequestMapping("/books/randomBook")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.ALL_VALUE})
    public ResponseEntity<Book> giveRandomBook(@RequestParam(value = "title", required = false) final String title) {

        Iterable<BookEntity> books;
        if (title != null) {
            books = bookRepository.findByTitle(title);
        } else {
            books = bookRepository.findAll();
        }

        List<BookEntity> bookList = IteratorUtils.toList(books.iterator());

        if (bookList != null) {
            Random random = new Random();
            int index = random.nextInt(bookList.size());
            Book randomBook = bookList.get(index);

            return new ResponseEntity<Book>(randomBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

    }
}
