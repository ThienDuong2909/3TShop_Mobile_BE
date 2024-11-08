package com.project._TShop.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project._TShop.DTO.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Category;
import com.project._TShop.Repositories.CategoryRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Response getAll(){
        Response response = new Response();
        try {
            List<Category> categories = categoryRepository.findAll();
            response.setStatus(200);
            response.setMessage("Get all category success");
            response.setCategoryDTOList(Utils.mapCategories(categories));
        } catch (Exception e) {
            System.out.print(e.toString());
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }
    public Response addCategory(CategoryDTO categoryDTO){
        Response response = new Response();
        try {
            if(categoryRepository.findByName(categoryDTO.getName().toUpperCase()).isPresent()){
                response.setStatus(209);
                response.setMessage("message: Category name had been used");
                return response;
            }
            var category = Category.builder()
                    .name(categoryDTO.getName())
                    .created_at(new Date())
                    .image(categoryDTO.getImage())
                    .status(1)
                    .build();
            categoryRepository.save(category);
            response.setStatus(200);
            response.setMessage("message: Add new category success");
        } catch (Exception e) {
            System.out.print(e.toString());
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }

    public Response updateCategory(CategoryDTO categoryDTO) {
        Response response = new Response();
        try {
            if(categoryRepository.findByName(categoryDTO.getName().toUpperCase()).isPresent()){
                response.setStatus(209);
                response.setMessage("message: Category name had been used");
                return response;
            }
            Optional<Category> category = Optional.ofNullable(categoryRepository.findByCategoryId(categoryDTO.getCategory_id()));

            category.get().setName(categoryDTO.getName());
            category.get().setImage(categoryDTO.getImage());
            categoryRepository.save(category.get());
            response.setStatus(200);
            response.setMessage("message: update category success");
        } catch (Exception e) {
            System.out.print(e.toString());
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }
}
