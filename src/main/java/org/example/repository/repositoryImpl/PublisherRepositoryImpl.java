package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Publisher;
import org.example.repository.PublisherRepository;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    private final EntityManager entityManager = Config.getEntityManager();
    @Override
    public String savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher.getName() + " is saved...";
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher= entityManager.find(Publisher.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllSortPublishersName(String ascOrDesc) {
        entityManager.getTransaction().begin();
        String orderBy = "ASC".equals(ascOrDesc) ? "name ASC" : "name DESC";
        String queryStr = "SELECT p FROM Publisher p ORDER BY " + orderBy;
        TypedQuery<Publisher> query = entityManager.createQuery(queryStr, Publisher.class);
        List<Publisher> publishers = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.find(Publisher.class,id);
        publisher1.setName(publisher1.getName());
        publisher1.setAddress(publisher1.getAddress());
        publisher1.setBooks(publisher1.getBooks());
        publisher1.setAuthors(publisher1.getAuthors());
        entityManager.merge(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher1.getName() + " is updated...";
    }

    @Override
    public void deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class,name);
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
