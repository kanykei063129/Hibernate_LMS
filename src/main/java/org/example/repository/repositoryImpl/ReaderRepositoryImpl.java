package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.Config;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.example.repository.ReaderRepository;

import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private final EntityManager entityManager = Config.getEntityManager();
    @Override
    public String saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader.getName() + " is saved...";
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        entityManager.getTransaction().begin();
        Reader reader1 = entityManager.find(Reader.class,id);
        reader1.setName(reader1.getName());
        reader1.setAge(reader1.getAge());
        reader1.setEmail(reader1.getEmail());
        reader1.setBook(reader1.getBook());
        entityManager.merge(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader1.getName() + " is updated...";
    }

    @Override
    public Reader getReaderByBookId(Long id){
        return null;
    }

    @Override
    public String deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class,id);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "deleted...";
    }

    @Override
    public List<Reader> getReadersByAuthorId(Long id){
        return null;
    }
}
