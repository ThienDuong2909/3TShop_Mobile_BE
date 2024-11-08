package com.project._TShop.Controllers;

import com.project._TShop.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project._TShop.Response.Response;
import com.project._TShop.Services.ProductService;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("get-all")
    public ResponseEntity<Response> getAll(){
        Response response = productService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("get-hot-products")
    public ResponseEntity<Response> getHotProduct(){
        Response response = productService.getHotProducts();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("get-new-products")
    public ResponseEntity<Response> getNewProduct(){
        Response response = productService.getNewProducts();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("add-product")
    public ResponseEntity<Response> addNewProduct(
            @RequestBody ProductDTO productDTO
            ){
        Response response = productService.addProduct(productDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<Response> getById(
            @PathVariable("id") Integer id
            ){
        Response response = productService.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("get-by-category-id/{id}")
    public ResponseEntity<Response> getByCategory(
            @PathVariable("id") Integer id
            ){
        Response response = productService.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
