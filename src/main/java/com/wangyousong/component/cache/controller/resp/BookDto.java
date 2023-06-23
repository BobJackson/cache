package com.wangyousong.component.cache.controller.resp;

import com.wangyousong.component.cache.entity.Book;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {
    private String id;
    private String title;
    private String subtitle;
    private String coverUrl;

    public BookDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.subtitle = entity.getSubtitle();
        this.coverUrl = entity.getCoverUrl();
    }
}
