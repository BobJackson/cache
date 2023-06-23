package com.wangyousong.component.cache.controller.resp;

import com.wangyousong.component.cache.entity.Book;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class BookDto implements Serializable {
    private String id;
    private String title;
    private String subtitle;
    private String coverUrl;
    private Instant createdAt;

    public BookDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.coverUrl = entity.getCoverUrl();
        this.createdAt = entity.getCreatedAt();
    }
}
