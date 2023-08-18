package com.springbootapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootapp.dto.BadRequestException;
import com.springbootapp.dto.BankInfo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Controller
public class BankController {
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    public String getAllDetails(@RequestParam("ifscCode") String ifscCode, Model model) throws JsonProcessingException {
        String url = "https://ifsc.razorpay.com/" + ifscCode;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> data = restTemplate.getForEntity(url, String.class);
            BankInfo bankInfo = objectMapper.readValue(data.getBody(), BankInfo.class);
            model.addAttribute("bankInfo", bankInfo);
            return "view-bank-details";
        } catch (HttpStatusCodeException exception) {
            System.out.println(exception.getMessage());
            throw new BadRequestException(exception.getStatusCode().value(), exception.getResponseBodyAsString());
        }
    }
}
