package com.exa.api.service

import com.exa.api.entity.Book

import java.util.List

interface BookService{

    List<Book> findAll()

    List<Book> findByCategoryId(Integer categoryId)

    Book findById(Integer id)

    Book saveBook(Book Book)

    Book deleteBook(Integer id)
    
    Book updateBook(Book Book, Integer id)
}