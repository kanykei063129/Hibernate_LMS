package org.example.service;

import org.example.model.Book;

public interface BookService {
    String saveBook(Book book);
    void updateBook(Long id,Book book);
    Book getBookAndPublisherByBookId(Long id);
    String deleteBookByAuthorId(Long id);
}
