package com.ilyastuit.book_library_spring.dao.impl;

import com.ilyastuit.book_library_spring.dao.AuthorDao;
import com.ilyastuit.book_library_spring.domain.Author;
import com.ilyastuit.book_library_spring.spring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(Long id) {
        Optional<Author> bookmark = authorRepository.findById(id);
        return bookmark.orElse(null);
    }

    @Override
    public Author save(Author obj) {
        return authorRepository.save(obj);
    }

    @Override
    public void delete(Author obj) {
        authorRepository.delete(obj);
    }

    @Override
    public List<Author> search(String... searchStrings) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchStrings[0]);
    }

    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String ...searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0], PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
    }
}
