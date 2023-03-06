package com.rootlab.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public String chatGet(Model model) {
        model.addAttribute("name", UUID.randomUUID().toString());
        return "chat";
    }
}