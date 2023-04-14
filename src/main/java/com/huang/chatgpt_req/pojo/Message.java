package com.huang.chatgpt_req.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    public static final String SYSTEM="system";
    public static final String USER="user";
    public static final String ASSISTANT="assistant";
    private String role;
    private String content;
}
