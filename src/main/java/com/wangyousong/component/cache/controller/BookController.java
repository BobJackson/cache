package com.wangyousong.component.cache.controller;

import com.wangyousong.component.cache.controller.cmd.CreateBookRequest;
import com.wangyousong.component.cache.controller.resp.BookDto;
import com.wangyousong.component.cache.entity.Book;
import com.wangyousong.component.cache.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> list() {
        return ResponseEntity.ok(bookService.listAllBooks());
    }

    @GetMapping("/cache")
    public ResponseEntity<List<BookDto>> listUsingCache() {
        return ResponseEntity.ok(bookService.cache());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateBookRequest request) {
        String id = bookService.createABook(request);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> update(@RequestBody CreateBookRequest request, @PathVariable String id) {
        bookService.updateBook(id, request);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(id);
    }
}
