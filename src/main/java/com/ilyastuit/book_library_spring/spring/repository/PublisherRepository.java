package com.ilyastuit.book_library_spring.spring.repository;

import com.ilyastuit.book_library_spring.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String name);
}
