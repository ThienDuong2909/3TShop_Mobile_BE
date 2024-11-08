package com.project._TShop.Controllers;

import com.project._TShop.DTO.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project._TShop.Response.Response;
import com.project._TShop.Services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/get-all")
    public ResponseEntity<Response> getAll(){
        Response response = categoryService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("/add-category")
    public ResponseEntity<Response> addCategory(
            @RequestBody CategoryDTO categoryDTO
            ){
        Response response = categoryService.addCategory(categoryDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
