package com.project._TShop.Services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project._TShop.DTO.ProductDTO;
import com.project._TShop.Entities.Category;
import com.project._TShop.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Product;
import com.project._TShop.Repositories.ProductRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

@Service
@RequiredArgsConstructor
public class ProductService {
@Autowired

    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public Response getAll(){
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAll();
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

    public Response getAvailableProduct(){
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
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

    public Response getById(Integer id){
        Response response = new Response();
        try {
            Optional<Product> product = productRepository.findById(id);
            if(product.isPresent()){
                response.setStatus(200);
                response.setMessage("Get product success");
                response.setProductDTO(Utils.mapProduct(product.get()));
            }else{
                response.setStatus(201);
                response.setMessage("Not found product");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    // public Response getByCategory(Integer id){
    //     Response response = new Response();
    //     try {
    //         Optional<Category> category = categoryRepository.findById(id);
    //         if(category.isPresent()){
    //             List<Product> products = productRepository.findByCategory(category.get().getCategory_id());
    //             response.setStatus(200);
    //             response.setMessage("Get products success");
    //             response.setProductDTOList(Utils.mapProducts(products));
    //         }else{
    //             response.setStatus(202);
    //             response.setMessage("Not found categorys");
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e);
    //         response.setStatus(500);
    //         response.setMessage("Server error");
    //     }
    //     return response;
    // }

    public Response getHotProducts() {
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
            products.sort(Comparator.comparingInt(Product::getSold).reversed());
            List<Product> top10Products = products.stream().limit(10).toList();
            response.setStatus(200);
            response.setMessage("Get hot products success");
            response.setProductDTOList(Utils.mapProducts(top10Products));
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response getByCategory(Integer idCategory) {
        Response response = new Response();
        try {
            Category category = categoryRepository.findById(idCategory)
                .orElseThrow(() -> new RuntimeException("Category not found"));
            List<Product> products = productRepository.findAvailableProducts();
            List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory_id().equals(category)) 
                .limit(10) 
                .toList();
            response.setStatus(200);
            response.setMessage("Get products by category success");
            response.setProductDTOList(Utils.mapProducts(filteredProducts));
        } catch (RuntimeException e) {
            response.setStatus(202);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }    

    public Response getNewProducts() {
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
            products.sort(Comparator.comparing(Product::getCreated_at).reversed());
            List<Product> top10NewProducts = products.stream().limit(10).toList();
            response.setStatus(200);
            response.setMessage("Get new products success");
            response.setProductDTOList(Utils.mapProducts(top10NewProducts));
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }    

    public Response addProduct(ProductDTO productDTO) {
        Response response = new Response();
        try {
            System.out.println(productDTO.getCategoryDTO().getCategory_id());
            Category category = categoryRepository.findByCategoryId(Integer.valueOf(productDTO.getCategoryDTO().getCategory_id()));
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

            productRepository.save(product);
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
