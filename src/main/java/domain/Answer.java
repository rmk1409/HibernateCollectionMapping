package domain;

import javax.persistence.*;

/**
 * Created by Roma on 14.09.2016.
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String description;
    @Column
    private String author;

    @ManyToOne
    @JoinColumn
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
