package domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roma on 14.09.2016.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String description;
    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

}
