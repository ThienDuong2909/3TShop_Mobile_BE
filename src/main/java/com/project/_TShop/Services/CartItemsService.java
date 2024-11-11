package com.project._TShop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.Cart;
import com.project._TShop.Entities.Cart_Items;
import com.project._TShop.Entities.Product;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.CartItemsRepository;
import com.project._TShop.Repositories.CartRepository;
import com.project._TShop.Repositories.ProductRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

@Service
public class CartItemsService {
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    public Response addToCart(int id){
        Response response = new Response();
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Optional <Product> product = productRepository.findById(id);
            Optional<Account> account = accountRepository.findByUsername(username);
            if(account.isPresent()){
                Optional<Cart> cart = cartRepository.findByAccount(account.get());
                if(cart.isPresent()){
                    // Cart_Items cart_Items = new Cart_Items(1, cart.get(), product.get());
                    // cartItemsRepository.save(cart_Items);
                    response.setStatus(200);
                    response.setMessage("success add cart");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Error server");
        }
        return response;
    }

    public Response getByAccount() {
        Response response = new Response();
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
            Cart cart = cartRepository.findByAccount(account)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
            List<Cart_Items> cartItems = cartItemsRepository.findByCart(cart);
            response.setStatus(200);
            response.setCart_ItemsDTOList(Utils.mapCartItems(cartItems));
            response.setMessage("Success get cart");
        } catch (RuntimeException e) {
            response.setStatus(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }    
}
