package com.huang.chatgpt_req.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RespEntity {
    private String id;
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private List<Choices> choices;
}
