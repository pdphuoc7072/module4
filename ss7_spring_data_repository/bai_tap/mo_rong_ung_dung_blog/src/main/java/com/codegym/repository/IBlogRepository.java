package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining (String title, Pageable pageable);
    Iterable<Blog> findAllByCategory (Category category);
    Page<Blog> findAllByOrderByCreateDayAsc (Pageable pageable);
    Page<Blog> findAllByOrderByCreateDayDesc (Pageable pageable);

    @Query(value = "SELECT * FROM blogs WHERE title LIKE :title AND category_id LIKE :id", nativeQuery = true)
    Page<Blog> findAll (Pageable pageable, @Param("title") String title,@Param("id") String idCategory);
}
