package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.repository.BookRepository;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager = Config.getEntityManager();
    @Override
    public String saveBook(Book book) {
        EntityManager entityManager1 = Config.getEntityManager();
       entityManager1.getTransaction().begin();
       entityManager1.persist(book);
       entityManager1.getTransaction().commit();
       entityManager1.close();
        return book.getName() + " is saved...";
    }

    @Override
    public void updateBook(Long id, Book book) {
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class,id);
        book1.setName(book1.getName());
        book1.setCountry(book1.getCountry());
        book1.setPublishedYear(book1.getPublishedYear());
        book1.setPrice(book1.getPrice());
        book1.setGenre(book1.getGenre());
        book1.setPublisher(book1.getPublisher());
        book1.setAuthor(book1.getAuthor());
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(book.getName() + " is updated...");
    }
    @Override
    public Book getBookAndPublisherByBookId(Long id) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        Publisher publisher = book.getPublisher();
        book.setPublisher(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }
    @Override
    public String deleteBookByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        List<Book> books = author.getBooks();
        for (Book book : books) {
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Books by author with ID " + id + " have been deleted.";
    }
}
