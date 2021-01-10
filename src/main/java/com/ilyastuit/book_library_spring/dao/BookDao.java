package com.ilyastuit.book_library_spring.dao;

import com.ilyastuit.book_library_spring.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookDao extends GeneralDao<Book>{

    List<Book> findTopBooks(int limit);

    byte[] getContent(Long id);

    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, Long genreId);
}
