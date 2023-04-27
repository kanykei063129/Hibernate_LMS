package org.example.service;

import org.example.model.Author;

import java.util.List;

public interface AuthorService {
    String saveAuthor(Author author);
    String updateAuthor(Long id,Author author);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long publisherId,Long authorId);
}
