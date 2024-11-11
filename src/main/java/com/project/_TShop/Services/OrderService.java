package com.project._TShop.Services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.Color;
import com.project._TShop.Entities.Delevery_Infomation;
import com.project._TShop.Entities.Order;
import com.project._TShop.Entities.Order_Detail;
import com.project._TShop.Entities.Order_Status;
import com.project._TShop.Entities.Product;
import com.project._TShop.Entities.Size;
import com.project._TShop.Entities.Specifications;
import com.project._TShop.Entities.User;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.CartItemsRepository;
import com.project._TShop.Repositories.ColorRepository;
import com.project._TShop.Repositories.DeleveryInformationRepository;
import com.project._TShop.Repositories.OrderDetailRepository;
import com.project._TShop.Repositories.OrderRepository;
import com.project._TShop.Repositories.OrderStatusRepository;
import com.project._TShop.Repositories.ProductRepository;
import com.project._TShop.Repositories.SizeRepository;
import com.project._TShop.Repositories.SpecificationsRepository;
import com.project._TShop.Repositories.UserRepository;
import com.project._TShop.Request.OrderDetailRequest;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
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

    @Transactional
    public Response createOrder(String username, Integer idAddress, List<OrderDetailRequest> orderRequests) {
        Response response = new Response();
        try {
            Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Not found account"));
            User user = userRepository.findByAccount(account)
                .orElseThrow(() -> new RuntimeException("Not found user"));
            Delevery_Infomation delevery_Infomation = deleveryInformationRepository.findById(idAddress)
                .orElseThrow(() -> new RuntimeException("Not found address"));
            Date date = new Date();
            Order order = new Order(
                delevery_Infomation.getName(),
                delevery_Infomation.getPhone(),
                delevery_Infomation.getAddress_line_1(),
                delevery_Infomation.getAddress_line_2(),
                BigDecimal.ZERO,
                date,
                user
            );
            orderRepository.save(order);
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (OrderDetailRequest orderRequest : orderRequests) {
                Integer productId = orderRequest.getProductId();
                Integer colorId = orderRequest.getColorId();
                Integer sizeId = orderRequest.getSizeId();
                Integer quantity = orderRequest.getQuantity();

                Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Not found product"));
                Color color = colorRepository.findById(colorId)
                    .orElseThrow(() -> new RuntimeException("Not found color"));
                Size size = sizeRepository.findById(sizeId)
                    .orElseThrow(() -> new RuntimeException("Not found size"));

                Specifications specifications = specificationsRepository.findByColorAndSizeAndProduct(color, size, product)
                    .orElseThrow(() -> new RuntimeException("Not found specifications")); 
                BigDecimal price = specifications.getProduct().getPrice().multiply(BigDecimal.valueOf(quantity));
                totalPrice = totalPrice.add(price);
                Order_Detail orderDetail = new Order_Detail(quantity, order, specifications);
                orderDetailRepository.save(orderDetail);
            }
            order.setTotal_price(totalPrice);
            orderRepository.save(order);
            Order_Status orderStatus = new Order_Status(1, date, order);
            orderStatusRepository.save(orderStatus);

            for (OrderDetailRequest orderRequest : orderRequests) {
                Integer productId = orderRequest.getProductId();
                Integer colorId = orderRequest.getColorId();
                Integer sizeId = orderRequest.getSizeId();
                
                Specifications specifications = specificationsRepository.findByColorAndSizeAndProduct(
                    colorRepository.findById(colorId).get(),
                    sizeRepository.findById(sizeId).get(),
                    productRepository.findById(productId).get()
                )
                    .orElseThrow(()-> new RuntimeException("Not found specificatións"));

                cartItemsRepository.deleteBySpecifications(specifications);
            }

            response.setMessage("Order created successfully!");
            response.setOrderDTO(Utils.mapOrder(order));
            response.setStatus(200);
        } catch (RuntimeException e) {
            response.setStatus(202);
            response.setMessage("Create failed");
        } catch (Exception e) {
            response.setMessage("Error: " + e.getMessage());
            response.setStatus(500);
            e.printStackTrace();
        }
        return response;
    }

}
