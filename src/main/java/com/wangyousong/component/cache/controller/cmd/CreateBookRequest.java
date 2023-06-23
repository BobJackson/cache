package com.wangyousong.component.cache.controller.cmd;

import com.wangyousong.component.cache.entity.Book;
import lombok.Data;

@Data
public class CreateBookRequest {
    private String title;
    private String subtitle;
    private String coverUrl;

    public Book toEntity() {
        Book entity = new Book();
        entity.setTitle(title);
        entity.setSubtitle(subtitle);
        entity.setCoverUrl(coverUrl);
        return entity;
    }
}
