package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.hibernate.HibernateError;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class Config {
    public static EntityManager getEntityManager() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty(DRIVER, "org.postgresql.Driver");
            configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/hibernate");
            configuration.setProperty(USER, "postgres");
            configuration.setProperty(PASS, "postgres");
            configuration.setProperty(HBM2DDL_AUTO, "update");
            configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty(SHOW_SQL, "true");
            configuration.addAnnotatedClass(Reader.class);
            configuration.addAnnotatedClass(Publisher.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            System.out.println("Successfully table created...");
            return configuration.buildSessionFactory().createEntityManager();
        }catch (HibernateError e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
