package org.example.repository;

import org.example.model.Author;

import java.util.List;

public interface AuthorRepository {
    String saveAuthor(Author author);
    String updateAuthor(Long id,Author author);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long publisherId,Long authorId);
}
