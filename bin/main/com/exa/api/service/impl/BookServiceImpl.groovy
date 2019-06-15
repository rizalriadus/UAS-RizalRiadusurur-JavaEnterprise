package com.exa.api.service.impl

import com.exa.api.entity.Book
import com.exa.api.repository.BookRepository
import com.exa.api.service.BookService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List;

@Service
class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookRepository

    @Override
    List<Book> findAll() {
        bookRepository.findAll()
    }

    @Override
    List<Book> findByCategoryId(Integer categoryId) {
        bookRepository.findByCategoryId(categoryId)
    }

    @Override
    Book findById(Integer id) {
        bookRepository.findById(id)
    }

    @Override
    Book saveBook(Book book) {
        bookRepository.save(book)
    }

    @Override
    Book deleteBook(Integer id) {
        Book delBook  = bookRepository.findById(id)
        if(delBook != null) {
            bookRepository.delete(delBook)
        }
        delBook
    }

    @Override
    Book updateBook(Book book, Integer id) {
        Book updateCat = bookRepository.findById(id)
        if(updateCat != null) {
            updateCat.setNama(book.getNama())
            updateCat.setJenis(book.getJenis())
            updateCat.setKet(book.getKet())
        }
        final Book myBook = bookRepository.save(updateCat);
        myBook
    }
}