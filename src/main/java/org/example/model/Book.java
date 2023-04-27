package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Gender;
import org.example.enums.Genre;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "books_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "books_gen",sequenceName = "books_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    @Column(name = "published_year")
    private LocalDate publishedYear;
    private int price;
    private Genre genre;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private Publisher publisher;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private Author author;

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre, Publisher publisher, Author author) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
    }

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre, Publisher publisher) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Book(String name, String country, LocalDate publishedYear, int price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", genre=" + genre +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }
}

