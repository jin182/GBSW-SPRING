package com.mysite.sbb.question;

import com.mysite.sbb.Answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    @ManyToOne
    private SiteUser author;

    public static interface QuestionRepository extends JpaRepository<Question, Integer> {
        List<Question> findBySubject(String subject);
        List<Question> findBySubjectContainsIgnoreCase(String subject);

        List<Question> findBySubjectLike(String subject);
    }
}
