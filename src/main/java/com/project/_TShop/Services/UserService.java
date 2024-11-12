package com.project._TShop.Services;


import com.project._TShop.DTO.AccountDTO;
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

    public Response getUserInfoCustomer() {
        Response response = new Response();
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Optional<User> currentUser = getCurrentUser();
            if (currentUser.isEmpty()) {
                response.setStatus(202);
                response.setMessage("Not found User Info");
                Account account = accountRepo.findByUsername(username)
                    .orElseThrow(()-> new RuntimeException("Not found accout"));
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setEmail(account.getEmail());
                response.setAccountDTO(accountDTO);
            } else {
                response.setStatus(200);
                response.setUserDTO(Utils.mapUser(currentUser.get()));
            }
        }catch(RuntimeException e){
            response.setStatus(400);
            response.setMessage(e.getMessage());
        }catch (Exception e) {
            response.setStatus(500);
            response.setMessage("Error server");
        }
        
        return response;
    }
}

