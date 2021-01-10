package com.ilyastuit.book_library_spring.spring.controller;

import com.ilyastuit.book_library_spring.spring.repository.AuthorRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log
@Controller
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(path = "/")
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }
}
