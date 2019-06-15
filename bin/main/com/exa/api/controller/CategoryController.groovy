package com.exa.api.controller

import com.exa.api.entity.Category
import com.exa.api.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*
import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
class CategoryController{
   @Autowired
   private final CategoryService categoryService

   @GetMapping("")
   List<Category> findAll(){
      categoryService.findAll()
   }

   @GetMapping("/{id}")
   public ResponseEntity<Category> findById(@PathVariable('id') Integer id){
      Map<String,String> response = new HashMap<String,String>();
      if(categoryService.findById(id) != null) {
         return ResponseEntity.ok(categoryService.findById(id))
      } else {
         response.put("status", "not found")
         response.put("message", "Category not found")
         return ResponseEntity.status(404).body(response)
      }
   }

   @PostMapping("")
   public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
      Map<String,String> response = new HashMap<String,String>()
      if(categoryService.saveCategory(category) != null) {
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
   public ResponseEntity<Category> updateCategory (@Valid @RequestBody Category category,
      @PathVariable(value= "id") Integer id) {
         Map<String,String> response = new HashMap<String,String>()
         if(categoryService.updateCategory(category, id) != null) {
            response.put("status", "success")
            response.put("message", "Data updated")
            return ResponseEntity.ok(response)
         } else {
            response.put("status", "not found")
            response.put("message", "Category not found")
            return ResponseEntity.status(404).body(response)
         }
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteCategory(@PathVariable(value= "id") Integer id) {
      Map<String,String> response = new HashMap<String,String>()
      if(categoryService.deleteCategory(id) != null) {
         response.put("status", "success")
         response.put("message", "Deleted success")
         return ResponseEntity.ok(response)
      } else {
         response.put("status", "not found")
         response.put("message", "Category not found")
         return ResponseEntity.status(404).body(response)
      }
   }
}