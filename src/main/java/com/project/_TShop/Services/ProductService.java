package com.project._TShop.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Product;
import com.project._TShop.Response.ProductRepo;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Response getAll(){
        Response response = new Response();
        try {
            List<Product> products = productRepo.findAll();
            response.setStatus(200);
            response.setMessage("Get all product success");
            response.setProductDTOList(Utils.mapProducts(products));
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }
}
