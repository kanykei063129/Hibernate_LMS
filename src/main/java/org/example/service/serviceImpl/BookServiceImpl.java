package org.example.service.serviceImpl;

import org.example.model.Book;
import org.example.repository.BookRepository;
import org.example.repository.repositoryImpl.BookRepositoryImpl;
import org.example.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
    bookRepository.updateBook(id,book);
    }

    @Override
    public Book getBookAndPublisherByBookId(Long id) {
        return bookRepository.getBookAndPublisherByBookId(id);
    }

    @Override
    public String deleteBookByAuthorId(Long id) {
        return bookRepository.deleteBookByAuthorId(id);
    }
}
