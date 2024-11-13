package com.project._TShop.Controllers;

import com.project._TShop.Request.ChangeSatusRequest;
import com.project._TShop.Request.OrderRequest;
import com.project._TShop.Response.Response;
import com.project._TShop.Services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {
    private final OrderService orderService;


    @GetMapping("/get-revenue")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> getRevenue(){
        Response response = orderService.getOrders(0);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
