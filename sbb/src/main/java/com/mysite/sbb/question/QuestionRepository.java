package com.mysite.sbb.question;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubject(String subject);
    List<Question> findBySubjectContainsIgnoreCase(String subject);
    List<Question> findBySubjectLike(String subject);

    @Override
    Page<Question> findAll(Pageable pageable);
}
