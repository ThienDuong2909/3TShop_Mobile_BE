package com.project._TShop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Product;
import com.project._TShop.Entities.Specifications;
import com.project._TShop.Repositories.ProductRepository;
import com.project._TShop.Repositories.SpecificationsRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SpecificationsService {
    private final SpecificationsRepository specificationsRepository;
    private final ProductRepository productRepository;

    public Response getByProduct(Integer productId){
        Response response = new Response();
        try {
            Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Not found product"));
            List<Specifications> specifications = specificationsRepository.findByProduct(product);
            response.setStatus(200);
            response.setMessage("Get success");
            response.setSpecificationsDTOList(Utils.mapSpecificationss(specifications));
        }catch (RuntimeException e){
            response.setStatus(201);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }
}
