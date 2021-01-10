package com.ilyastuit.book_library_spring.dao.impl;

import com.ilyastuit.book_library_spring.dao.BookDao;
import com.ilyastuit.book_library_spring.domain.Book;
import com.ilyastuit.book_library_spring.spring.repository.BookRepository;
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
public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0,limit, Sort.by(Sort.Direction.DESC, "viewCount")));
    }

    @Override
    public byte[] getContent(Long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, Long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    @Override
    public Book save(Book obj) {
        bookRepository.save(obj);

        if (obj.getContent()!=null) {
            bookRepository.updateContent(obj.getContent(), obj.getId());
        }

        return obj;
    }

    @Override
    public void delete(Book obj) {
        bookRepository.delete(obj);
    }

    @Override
    public List<Book> search(String... searchStrings) {
        return null;
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String ...searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0], searchString[0], PageRequest.of(pageNumber, pageSize, sortDirection, sortField));
    }
}