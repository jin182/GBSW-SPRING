package com.example.memo.controller;

import com.example.memo.dto.AddMemoRequest;
import com.example.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memos")
    public String listMemos(Model model) {
        model.addAttribute("memos", memoService.getMemos());
        return "index"; // Matches index.html
    }

    @GetMapping("/memos/add")
    public String showAddMemoForm(Model model) {
        model.addAttribute("addMemoRequest", new AddMemoRequest());
        return "memoform"; // Matches memoform.html
    }

    @PostMapping("/memos/add")
    public String addMemo(AddMemoRequest request) {
        memoService.addMemo(request);
        return "redirect:/memos";
    }
}