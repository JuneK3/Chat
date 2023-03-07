package com.rootlab.chat.controller;

import com.rootlab.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;

    //채팅방 목록 조회
    @GetMapping("/rooms")
    public ModelAndView rooms() {
        ModelAndView mv = new ModelAndView("chat/rooms");
        mv.addObject("chatRooms", chatRoomRepository.findAllRooms());
        return mv;
    }

    //채팅방 개설
    @PostMapping("/room")
    public String create(@RequestParam String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("roomName", chatRoomRepository.createChatRoom(name));
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String getRoom(@RequestParam String roomId, Model model) {
        model.addAttribute("room", chatRoomRepository.findRoomById(roomId));
        return "/chat/room";
    }
}