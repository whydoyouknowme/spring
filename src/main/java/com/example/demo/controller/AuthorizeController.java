package com.example.demo.controller;

import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.GithubUser;
import com.example.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                            @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("b9db753ebf9b7c3904b3");
        accessTokenDTO.setClient_secret("2e09a15229cc85b9f3f927ea4abaf1596345dd5d");
        accessTokenDTO.setRedirect_uri("http://127.0.0.1:8887/callback");
        accessTokenDTO.setState(state);
        String accesstoken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUer(accesstoken);
        System.out.println(user.getName());
        return "index";
    }
}
