package com.ilyastuit.book_library_spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDao<T> {

    List<T> getAll();

    T get(Long id);

    T save(T obj);

    void delete(T obj);

    List<T> search(String ...searchStrings);

    List<T> getAll(Sort sort);

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String ...searchString);
}
