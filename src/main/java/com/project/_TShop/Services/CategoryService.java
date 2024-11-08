package com.project._TShop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Category;
import com.project._TShop.Repositories.CategoryeRepo;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

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
}
