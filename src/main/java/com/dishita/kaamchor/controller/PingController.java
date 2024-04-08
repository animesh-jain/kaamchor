package com.dishita.kaamchor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:19006")
public class PingController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/ping")
    public String ping() throws JsonProcessingException {
        Map<String, String> response = new HashMap<String, String>() {{
            put("message", "Pong!");
        }};

        return objectMapper.writeValueAsString(response);
    }
}
