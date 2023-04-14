package com.huang.chatgpt_req.service;

import com.huang.chatgpt_req.dto.ChatgptBaseParamDto;

import java.util.Map;

public interface ChatgptptService {
    Object sendMsg(ChatgptBaseParamDto chatgptBaseParamDto);
}
