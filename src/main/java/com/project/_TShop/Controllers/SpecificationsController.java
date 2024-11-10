package com.project._TShop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project._TShop.Entities.Specifications;
import com.project._TShop.Repositories.SpecificationsRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Services.SpecificationsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/specifications")
@RequiredArgsConstructor

public class SpecificationsController {
    private final SpecificationsService specificationsService;

    @GetMapping("/get-by-product/{id}")
    public ResponseEntity<Response> getByProduct(@PathVariable("id") int productId){
        Response response = specificationsService.getByProduct(productId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
