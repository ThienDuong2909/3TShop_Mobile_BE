package com.project._TShop.Services;


import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.User;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.UserRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final AccountRepository accountRepo;


    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: "+((UserDetails) authentication.getPrincipal()).getUsername());

        if (!authentication.isAuthenticated()) {
//            System.out.println("username: "+((UserDetails) authentication.getPrincipal()).getUsername());
            return Optional.empty();
        }
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        System.out.println("username: "+ username);
        Optional<Account> account = accountRepo.findByUsername(username);

        return userRepo.findByAccount_Username(username);
    }

    public Response getUserInfo() {
        Response response = new Response();
        Optional<User> currentUser = getCurrentUser();
        if (currentUser.isEmpty()) {
            response.setStatus(201);
            response.setMessage("message: Not found User Info");
        } else {
            response.setStatus(200);
            response.setUserDTO(Utils.mapUser(currentUser.get()));
        }
        return response;
    }
}

