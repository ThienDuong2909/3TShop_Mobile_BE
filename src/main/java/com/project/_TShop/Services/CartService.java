package com.project._TShop.Services;


import com.project._TShop.Entities.User;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.UserRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final UserRepository userRepo;
    private final AccountRepository accountRepo;


//    public Optional<User> getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return Optional.empty();
//        }
//        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
//        return Optional.ofNullable(userRepo.findByAccount_Username(username));
//    }
//
//    public Response getUserInfo() {
//        Response response = new Response();
//        Optional<User> currentUser = getCurrentUser();
//        if (currentUser.isEmpty()) {
//            response.setStatus(404);
//            response.setMessage("message: Not found User Info");
//        } else {
//            response.setStatus(200);
//            response.setUserDTO(Utils.mapUser(currentUser.get()));
//        }
//        return response;
//    }
}

