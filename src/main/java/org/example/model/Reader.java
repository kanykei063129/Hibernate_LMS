package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reader {
    @Id
    @GeneratedValue(generator = "reader_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reader_gen",sequenceName = "reader_seq",allocationSize = 1)
    private Long id;
    private String name;
    private int age;
    private String email;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private Book book;

    public Reader(String name, int age, String email, Book book) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.book = book;
    }

    public Reader(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
