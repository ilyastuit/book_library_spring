package com.ilyastuit.book_library_spring.dao;

import java.util.List;

public interface GeneralDao<T> {

    List<T> getAll();

    T get(Long id);

    T save(T obj);

    void delete(T obj);

    List<T> search(String ...searchStrings);
}
