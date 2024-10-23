package com.mysite.sbb.question;


import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;
    @GetMapping("/list")
    public String getList(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }
    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    @GetMapping("/create")
    public String getCreateQuestion(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String postCreateQuestion(
            @Valid QuestionForm questionForm,
            BindingResult bindingResult,
            Principal principal
    ) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser user = userService.getUser(principal.getName());
        {
            questionService.create(questionForm.getSubject(), questionForm.getContent(), user);
            return "redirect:/question/list";
        }

    }
}
