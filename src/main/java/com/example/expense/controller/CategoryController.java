package com.example.expense.controller;

import com.example.expense.models.Category;
import com.example.expense.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    List<Category> categories(){
        return categoryRepository.findAll();

    }
    @GetMapping("/categories/{id}")
    ResponseEntity<?> getCategory(@PathVariable Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepository.save(category);
        return (ResponseEntity<Category>) ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

    }
    @PutMapping("/category/{id}")
    ResponseEntity<Category> update ( @RequestBody  Category category){
        Category result = categoryRepository.save(category);
        return  ResponseEntity.ok().body(result);

    }
    @DeleteMapping("/category/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id){
        categoryRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }


}
