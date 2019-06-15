package com.exa.api.repository

import com.exa.api.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findAll()

    Book findById(Integer id)

    List<Book> findByCategoryId(Integer categoryId)
}