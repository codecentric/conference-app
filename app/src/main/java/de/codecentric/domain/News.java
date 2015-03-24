package de.codecentric.domain;

import javax.persistence.*;

@Entity(name = "news")
@NamedQueries({ @NamedQuery(name = "findAllNews", query = "from news")})
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 2048)
    private String text;

    public News() {
        // JPA default constructor
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
