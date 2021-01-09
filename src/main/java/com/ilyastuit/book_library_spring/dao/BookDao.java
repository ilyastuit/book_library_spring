package com.ilyastuit.book_library_spring.dao;

import com.ilyastuit.book_library_spring.domain.Book;

import java.util.List;

public interface BookDao extends GeneralDao<Book>{

    List<Book> findTopBooks(int limit);
}
