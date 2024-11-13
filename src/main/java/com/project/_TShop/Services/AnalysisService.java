package com.project._TShop.Services;

import com.project._TShop.DTO.Order_DetailDTO;
import com.project._TShop.Entities.*;
import com.project._TShop.Exceptions.ResourceNotFoundException;
import com.project._TShop.Repositories.*;
import com.project._TShop.Request.ChangeSatusRequest;
import com.project._TShop.Request.OrderDetailRequest;
import com.project._TShop.Response.OrderResponse;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final DeleveryInformationRepository deleveryInformationRepository;
    private final SizeRepository sizeRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final ProductRepository productRepository;
    private final SpecificationsRepository specificationsRepository;
    private final CartItemsRepository cartItemsRepository;
    private final ColorRepository colorRepository;
    private final AccountRepository accountRepository;


    public Response getRevenue () {
        Response response = new Response();
            try{
                List<Order_Status> orderStatusList = orderStatusList = orderStatusRepository.findAllByStatus(3)
                        .orElseThrow(()-> new ResourceNotFoundException("Order_status", "status", 3));


            }catch (ResourceNotFoundException e){
                response.setStatus(201);
                response.setMessage(e.getMessage());
            }catch (Exception e){
                response.setStatus(500);
                response.setMessage(e.getMessage());
            }

        return response;
    }

}
