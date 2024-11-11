package com.project._TShop.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project._TShop.Request.OrderDetailRequest;
import com.project._TShop.Request.OrderRequest;
import com.project._TShop.Response.Response;
import com.project._TShop.Services.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Response> createNewOrder(@RequestBody OrderRequest orderRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.print("User name là: " + orderRequest);
        Response response = orderService.createOrder(username, orderRequest.getIdAddress(), orderRequest.getOrderRequests());
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
