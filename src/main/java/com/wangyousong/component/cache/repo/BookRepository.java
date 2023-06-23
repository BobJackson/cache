package com.wangyousong.component.cache.repo;

import com.wangyousong.component.cache.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
