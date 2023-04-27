package org.example.repository;

import org.example.model.Book;

public interface BookRepository {
    String saveBook(Book book);
    void updateBook(Long id,Book book);
    Book getBookAndPublisherByBookId(Long id);
    String deleteBookByAuthorId(Long id);
}
