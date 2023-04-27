package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Publisher;
import org.example.repository.AuthorRepository;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final EntityManager entityManager = Config.getEntityManager();
    @Override
    public String saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author.getFirstName() + " is saved...";
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.find(Author.class,id);
        author1.setFirstName(author1.getFirstName());
        author1.setEmail(author1.getEmail());
        author1.setDateOfBirth(author1.getDateOfBirth());
        author1.setCountry(author1.getCountry());
        author1.setGender(author1.getGender());
        author1.setPublishers(author1.getPublishers());
        author1.setBooks(author1.getBooks());
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author.getFirstName() + " is updated...";
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        return author1;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherId) {
        Query query = entityManager.createQuery(
                "SELECT a FROM Author a JOIN a.publishers p WHERE p.id = :publisherId");
        query.setParameter("publisherId", publisherId);
        List<Author> authors = query.getResultList();
        return authors;
    }

    @Override
    public void deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class,id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignAuthorToPublisher(Long publisherId,Long authorId) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class,publisherId);
        Author author = entityManager.find(Author.class,authorId);
        author.setPublishers((List<Publisher>) publisher);
        publisher.setAuthors((List<Author>) author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
