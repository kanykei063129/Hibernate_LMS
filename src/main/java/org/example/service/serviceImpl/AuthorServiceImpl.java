package org.example.service.serviceImpl;

import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.repositoryImpl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();

    @Override
    public String saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        return authorRepository.updateAuthor(id, author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        return authorRepository.getAuthorsByPublisherId(publisherId);
    }

    @Override
    public void deleteAuthorById(Long id) {
    authorRepository.deleteAuthorById(id);
    }

    @Override
    public void assignAuthorToPublisher(Long publisherId,Long authorId) {
    authorRepository.assignAuthorToPublisher(publisherId,authorId);
    }
}
