package com.huang.chatgpt_req.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huang.chatgpt_req.dto.ChatgptBaseParamDto;
import com.huang.chatgpt_req.pojo.Message;
import com.huang.chatgpt_req.pojo.RespEntity;
import com.huang.chatgpt_req.service.ChatgptptService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ChatgptServiceImpl implements ChatgptptService {

    @Override
    public Object sendMsg(ChatgptBaseParamDto chatgptBaseParamDto) {

        String url=chatgptBaseParamDto.getUrl();

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",chatgptBaseParamDto.getAuthorization());
        headers.set("Content-Type","application/json");

        //请求体
        JSONObject paramMap = new JSONObject();
        paramMap.put("model",chatgptBaseParamDto.getModel());
        paramMap.put("max_tokens",chatgptBaseParamDto.getMax_tokens());
        paramMap.put("temperature",chatgptBaseParamDto.getTemperature());
        paramMap.put("top_p",chatgptBaseParamDto.getTop_p());
        paramMap.put("n",chatgptBaseParamDto.getN());
        paramMap.put("stream",chatgptBaseParamDto.isBstream());
        paramMap.put("messages", chatgptBaseParamDto.getMessages());
        //整合请求头和请求参数
        HttpEntity<com.alibaba.fastjson.JSONObject> httpEntity = new HttpEntity<>(paramMap, headers);
        //请求客户端
        RestTemplate rt = new RestTemplate();
        //发起请求
        ResponseEntity<RespEntity> result = rt.postForEntity(url, httpEntity, RespEntity.class);
        if (result.getStatusCodeValue()==200){
            System.out.println(result.getBody().getChoices());
            Message message = result.getBody().getChoices().get(0).getMessage();
            //显示
            return result.getBody();
        }else {
            return null;
        }

    }
}
