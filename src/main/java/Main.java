import domain.Answer;
import domain.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roma on 14.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        Session session = configuration.buildSessionFactory(serviceRegistry).openSession();

        Transaction transaction = session.beginTransaction();

        Question q1 = new Question();
        q1.setDescription("What is Java?");

        session.persist(q1);

        Answer a1 = new Answer();
        a1.setDescription("Java is programming language");
        a1.setAuthor("Max");
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setDescription("Java is write once, run anywhere");
        a2.setAuthor("Alsi");
        a2.setQuestion(q1);

        List<Answer> l1 = new ArrayList<Answer>();

        l1.add(a1);
        l1.add(a2);
        q1.setAnswerList(l1);

        session.persist(a1);
        session.persist(a2);

        transaction.commit();
        session.close();
    }
}
