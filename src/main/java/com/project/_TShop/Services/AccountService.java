package com.project._TShop.Services;

import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.Auth_Provider;
import com.project._TShop.Entities.Cart;
import com.project._TShop.Entities.Role;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.RoleRepository;
import com.project._TShop.Request.RegisterRequest;
import com.project._TShop.Response.AuthenticationResponse;
import com.project._TShop.Response.Response;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepo;
    public Response isValidRegistrationToken(String code) {
        Response response = new Response();
        Optional<Account> accountOptional = accountRepo.findByRegistrationToken(code);
        if(accountOptional.isPresent()){
            accountOptional.get().setStatus(true);
//            var cart = Cart.builder()
//                            .user()
            accountRepo.save(accountOptional.get());
            response.setStatus(200);
            response.setMessage("Verify Account success");
        }else {
            response.setStatus(404);
            response.setMessage("Verify token is not exist");
        }
       return response;
    }
}

