package com.huang.chatgpt_req.controller;

import com.huang.chatgpt_req.dto.ChatgptBaseParamDto;
import com.huang.chatgpt_req.service.ChatgptptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class MessageController {

    private ChatgptptService chatgptptService;

    @Autowired
    public void setChatgptptService(ChatgptptService chatgptptService) {
        this.chatgptptService = chatgptptService;
    }

    @PostMapping("/sendMessage")
    Object sendMessage(@RequestBody ChatgptBaseParamDto chatgptBaseParamDto){
        return chatgptptService.sendMsg(chatgptBaseParamDto);
    }


}
