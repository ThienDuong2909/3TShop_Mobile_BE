package com.project._TShop.Services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project._TShop.DTO.CategoryDTO;
import com.project._TShop.DTO.ProductDTO;
import com.project._TShop.Entities.Category;
import com.project._TShop.Repositories.CategoryeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Product;
import com.project._TShop.Repositories.ProductRepo;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

@Service
@RequiredArgsConstructor
public class ProductService {
@Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryeRepo categoryRepo;

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
    public Response getHotProducts(){
        Response response = new Response();
        try {
            List<Product> products = productRepo.findTop10ByOrderBySoldDesc();
            response.setStatus(200);
            response.setMessage("Get hot products success");
            response.setProductDTOList(Utils.mapProducts(products));
        } catch (Exception e) {
            System.out.println("Lỗi" + e.toString());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }
    public Response getNewProducts(){
        Response response = new Response();
        try {
            List<Product> products = productRepo.findTop10ByCreatedAtDescNative();
            response.setStatus(200);
            response.setMessage("Get new products success");
            response.setProductDTOList(Utils.mapProducts(products));
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response addProduct(ProductDTO productDTO) {
        Response response = new Response();
        try {
            System.out.println(productDTO.getCategoryDTO().getCategory_id());
            Category category = categoryRepo.findByCategoryId(Integer.valueOf(productDTO.getCategoryDTO().getCategory_id()));
            if (category == null) {
                response.setStatus(400);
                response.setMessage("Category not found");
                return response;
            }

            var product = Product.builder()
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .price(productDTO.getPrice())
                    .sold(productDTO.getSold())
                    .which_gender(productDTO.getWhich_gender())
                    .created_at(new Date())
                    .category_id(category)
                    .status(1)
                    .build();

            productRepo.save(product);
            response.setStatus(200);
            response.setMessage("Add new product success");
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

}
