package com.exa.api.service.impl

import com.exa.api.entity.Category
import com.exa.api.repository.CategoryRepository
import com.exa.api.service.CategoryService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List;

@Service
class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository

    @Override
    List<Category> findAll() {
        categoryRepository.findAll()
    }

    @Override
    Category findById(Integer id) {
        categoryRepository.findById(id)
    }

    @Override
    Category saveCategory(Category category) {
        categoryRepository.save(category)
    }

    @Override
    Category deleteCategory(Integer id) {
        Category delCategory  = categoryRepository.findById(id)
        if(delCategory != null) {
            categoryRepository.delete(delCategory)
        }
        delCategory
    }

    @Override
    Category updateCategory(Category category, Integer id) {
        Category updateCat = categoryRepository.findById(id)
        if(updateCat != null) {
            updateCat.setNama(category.getNama())
            updateCat.setJenis(category.getJenis())
            updateCat.setKet(category.getKet())
        }
        final Category myCategory = categoryRepository.save(updateCat);
        myCategory
    }
}