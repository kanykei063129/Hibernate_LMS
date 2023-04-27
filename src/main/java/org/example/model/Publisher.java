package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(generator = "publisher_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "publisher_gen", sequenceName = "publisher_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private List<Book>books;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private List<Author>authors;

    public Publisher(String name, String address, List<Book> books, List<Author> authors) {
        this.name = name;
        this.address = address;
        this.books = books;
        this.authors = authors;
    }

    public Publisher(String name, String address, List<Book> books) {
        this.name = name;
        this.address = address;
        this.books = books;
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
