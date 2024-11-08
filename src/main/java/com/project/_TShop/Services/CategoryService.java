package com.project._TShop.Services;

import java.util.Date;
import java.util.List;

import com.project._TShop.DTO.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Category;
import com.project._TShop.Repositories.CategoryeRepo;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired
    CategoryeRepo categoryeRepo;
    public Response getAll(){
        Response response = new Response();
        try {
            List<Category> categories = categoryeRepo.findAll();
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
            if(categoryeRepo.findByName(categoryDTO.getName()) != null){
                response.setStatus(409);
                response.setMessage("message: Category name had been used");
                return response;
            }
            var category = Category.builder()
                    .name(categoryDTO.getName())
                    .created_at(new Date())
                    .image(categoryDTO.getImage())
                    .status(1)
                    .build();
            categoryeRepo.save(category);
            response.setStatus(200);
            response.setMessage("message: Add new category success");
        } catch (Exception e) {
            System.out.print(e.toString());
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }
}
