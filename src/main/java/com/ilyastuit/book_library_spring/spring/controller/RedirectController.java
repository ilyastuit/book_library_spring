package com.ilyastuit.book_library_spring.spring.controller;

import com.ilyastuit.book_library_spring.domain.Author;
import com.ilyastuit.book_library_spring.spring.repository.AuthorRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log
@Controller
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        //List<Author> authorList = authorRepository.findAll();

        Page<Author> pageList = authorRepository.findByFioContainingIgnoreCaseOrderByFio("D", PageRequest.of(0, 10,Sort.by(Sort.Direction.ASC, "fio")));

        return "ok";
    }
}
