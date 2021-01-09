package com.ilyastuit.book_library_spring.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vote", catalog = "library")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Column(name = "book_id")
    private Date bookId;

    private String username;
}
