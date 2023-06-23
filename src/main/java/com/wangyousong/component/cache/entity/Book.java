package com.wangyousong.component.cache.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;


@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotEmpty(message = "title is required")
    @Length(max = 255, message = "title is too long, title must less than 255")
    private String title;

    private String subtitle;

    @NotEmpty(message = "coverUrl is required")
    private String coverUrl;

}
