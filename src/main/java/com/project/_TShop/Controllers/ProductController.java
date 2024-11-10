package com.project._TShop.Controllers;

import com.project._TShop.DTO.ProductDTO;
import com.project._TShop.Request.ProductWithSpecificationsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

//    {
//        "productDTO": {
//        "name": "Áo thun tay ngắn",
//                "description": "Áo thun tay ngắn, mặc thoáng mát cho mùa hè nóng bức.",
//                "price": 200000,
//                "sold": 3,
//                "which_gender": true,
//                "categoryDTO": {
//            "category_id": 1
//        }
//    },
//        "specificationsDTO": [
//        {
//            "quantity": 2,
//                "colorDTO": {
//            "color_id": 1
//        },
//            "sizeDTO": {
//            "size_id": 1
//        }
//        },
//        {
//            "quantity": 5,
//                "colorDTO": {
//            "color_id": 2
//        },
//            "sizeDTO": {
//            "size_id": 2
//        }
//        }
//    ]
//    }
    @PostMapping("add-product")
    public ResponseEntity<Response> addNewProduct(
            @RequestBody ProductWithSpecificationsRequest request
            ){
        Response response = productService.addProduct(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
//    {
//        "product_id": 12,
//            "status": 0
//    }
    @PutMapping("change-status")
    public ResponseEntity<Response> changeStatus(
            @RequestBody ProductDTO productDTO
    ){
        Response response = productService.changeStatusOfProduct(productDTO);
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
    @GetMapping("search")
    public ResponseEntity<Response> searchProduct(
            @RequestParam("name") String product_name
    ){
        Response response = productService.searchByName(product_name);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
