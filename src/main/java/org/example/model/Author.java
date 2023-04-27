package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(generator = "authors_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "authors_gen",sequenceName = "authors_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(mappedBy = "authors",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private List<Publisher>publishers;
    @OneToMany(mappedBy = "author",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.DETACH,CascadeType.MERGE})
    private List<Book>books;

    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender, List<Publisher> publishers, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
        this.publishers = publishers;
        this.books = books;
    }

    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender, List<Publisher> publishers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
        this.publishers = publishers;
    }

    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", publishers=" + publishers +
                ", books=" + books +
                '}';
    }
}
