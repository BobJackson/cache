package com.wangyousong.component.cache.service;

import com.wangyousong.component.cache.controller.cmd.CreateBookRequest;
import com.wangyousong.component.cache.controller.resp.BookDto;
import com.wangyousong.component.cache.entity.Book;
import com.wangyousong.component.cache.exception.ResourceNotFoundException;
import com.wangyousong.component.cache.repo.BookRepository;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository repository;

    @Override
    public List<Book> listAllBooks() {
        Sort sortByCreatedAtDesc = Sort.by(Sort.Direction.DESC, "createdAt");
        return repository.findAll(sortByCreatedAtDesc);
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public String createABook(CreateBookRequest request) {
        Book saved = repository.save(request.toEntity());
        return saved.getId();
    }

    @Override
    @CacheEvict(value = "books", allEntries = true)
    public void updateBook(String id, CreateBookRequest request) {
        Optional<Book> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("can't find book with id " + id);
        }
        optional.ifPresent(book -> {
            book.setTitle(request.getTitle());
            book.setSubtitle(request.getSubtitle());
            book.setCoverUrl(request.getCoverUrl());
            book.setDescription(request.getDescription());
            repository.save(book);
        });
    }

    @Override
    public void deleteBook(String id) {
        repository.deleteById(id);
    }

    @Override
    @Cacheable(value = "books")
    public List<BookDto> cache() {
        return listAllBooks().stream().map(BookDto::new).toList();
    }
}
