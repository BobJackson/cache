package com.wangyousong.component.cache.service;

import com.wangyousong.component.cache.controller.cmd.CreateBookRequest;
import com.wangyousong.component.cache.controller.resp.BookDto;
import com.wangyousong.component.cache.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> listAllBooks();

    String createABook(CreateBookRequest request);

    void updateBook(String id, CreateBookRequest request);

    void deleteBook(String id);

    List<BookDto> cache();
}
