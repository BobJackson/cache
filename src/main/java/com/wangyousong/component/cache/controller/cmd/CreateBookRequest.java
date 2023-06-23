package com.wangyousong.component.cache.controller.cmd;

import com.wangyousong.component.cache.entity.Book;
import lombok.Data;

import java.time.Instant;

@Data
public class CreateBookRequest {
    private String title;
    private String subtitle;
    private String coverUrl;
    private Instant createdAt;

    public Book toEntity() {
        Book entity = new Book();
        entity.setTitle(title);
        entity.setSubtitle(subtitle);
        entity.setCoverUrl(coverUrl);
        entity.setCreatedAt(createdAt);
        return entity;
    }
}
