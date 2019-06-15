package com.exa.api.service

import com.exa.api.entity.Category

import java.util.List

interface CategoryService{

    List<Category> findAll()

    Category findById(Integer id)

    Category saveCategory(Category category)

    Category deleteCategory(Integer id)

    Category updateCategory(Category category, Integer id)
}