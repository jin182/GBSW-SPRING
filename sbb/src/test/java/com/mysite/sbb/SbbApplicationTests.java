package com.mysite.sbb;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import com.mysite.sbb.Answer.Answer;
import com.mysite.sbb.Answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SbbApplicationTests {
@Autowired
private QuestionService questionService;
	@Test
	void testJpa() {
		for(int i = 1; i < 300; i++) {
			String subject = String.format("테스트 데이터 %03d입니다.", i);
			String content = String.format("테스트 데이터 %03d의 내용입니다.",i);
			questionService.create(subject, content, null);
		}
	}

}