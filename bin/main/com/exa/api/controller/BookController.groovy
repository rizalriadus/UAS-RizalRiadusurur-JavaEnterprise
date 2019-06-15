package com.exa.api.controller

import com.exa.api.entity.Book
import com.exa.api.service.BookService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*
import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/books")
class BookController{
   @Autowired
   private final BookService bookService

   @GetMapping("")
   List<Book> findAll(){
      bookService.findAll()
   }

   @GetMapping("/{id}")
   public ResponseEntity<Book> findById(@PathVariable('id') Integer id){
      Map<String,String> response = new HashMap<String,String>();
      if(bookService.findById(id) != null) {
         return ResponseEntity.ok(bookService.findById(id))
      } else {
         response.put("status", "not found")
         response.put("message", "Book not found")
         return ResponseEntity.status(404).body(response)
      }
   }

   @GetMapping("/category/{id}")
   public ResponseEntity<Book> findByCategoryId(@PathVariable('id') Integer categoryId) {
       Map<String,String> response = new HashMap<String,String>();
       if(bookService.findByCategoryId(categoryId) != null) {
           return ResponseEntity.ok(bookService.findByCategoryId(categoryId))
       } else {
           response.put("status", "not found")
           response.put("message", "Book not found")
           return ResponseEntity.status.body(response)
       }
   }

   @PostMapping("")
   public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
      Map<String,String> response = new HashMap<String,String>()
      if(bookService.saveBook(book) != null) {
         response.put("status", "success")
         response.put("message", "Data created")
         return ResponseEntity.ok(response)
      } else {
         response.put("status", "error")
         response.put("message", "Failed to add data")
         return ResponseEntity.status(500).body(response)
      }
   }

   @PutMapping("/{id}")
   public ResponseEntity<Book> updateBook (@Valid @RequestBody Book book,
      @PathVariable(value= "id") Integer id) {
         Map<String,String> response = new HashMap<String,String>()
         if(bookService.updateBook(book, id) != null) {
            response.put("status", "success")
            response.put("message", "Data updated")
            return ResponseEntity.ok(response)
         } else {
            response.put("status", "not found")
            response.put("message", "Book not found")
            return ResponseEntity.status(404).body(response)
         }
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteBook(@PathVariable(value= "id") Integer id) {
      Map<String,String> response = new HashMap<String,String>()
      if(bookService.deleteBook(id) != null) {
         response.put("status", "success")
         response.put("message", "Deleted success")
         return ResponseEntity.ok(response)
      } else {
         response.put("status", "not found")
         response.put("message", "Book not found")
         return ResponseEntity.status(404).body(response)
      }
   }
}