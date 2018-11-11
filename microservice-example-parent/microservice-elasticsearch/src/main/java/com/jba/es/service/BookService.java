package com.jba.es.service;
/**
 * @author Jude
 */
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.jba.es.model.Book;

public interface BookService {

    Book save(Book book);

    void delete(Book book);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);

}