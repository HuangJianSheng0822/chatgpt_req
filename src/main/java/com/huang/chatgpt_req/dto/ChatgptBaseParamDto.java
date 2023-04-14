package com.huang.chatgpt_req.dto;

import com.huang.chatgpt_req.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatgptBaseParamDto {
    private String url;
    private String authorization;
    private String model;
    private int max_tokens;
    private double temperature;
    private int top_p;
    private int n;
    private boolean bstream;
    private List<Message> messages;
}
