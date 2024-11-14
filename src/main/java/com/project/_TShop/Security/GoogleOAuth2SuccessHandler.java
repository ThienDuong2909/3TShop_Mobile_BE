package com.project._TShop.Security;

import com.project._TShop.Entities.Account;
import com.project._TShop.Entities.Auth_Provider;
import com.project._TShop.Entities.Role;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.RoleRepository;
import com.project._TShop.Services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final AccountRepository accountRepo;
    private final JwtService jwtService;
    private final RoleRepository roleRepo;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
//        String Username = oAuth2User.getAttribute("name")
        Account account = accountRepo.findByEmail(email).orElseGet(() -> {
            Collection<Role> roles = new ArrayList<>();
            Optional<Role> optionalRole = roleRepo.findByName("USER");

            roles.add(optionalRole.get());

            Account newAccount = new Account();
            newAccount.setEmail(email);
            newAccount.setUsername(email);
            newAccount.setAuth_provider(String.valueOf(Auth_Provider.GOOGLE));
            newAccount.setStatus(true);
            newAccount.setCreatedAt(new Date());
            newAccount.setRoles(roles);
            return accountRepo.save(newAccount);
        });

        String token = jwtService.generateToken(account);
//        ResponseEntity<String> responseEntity = ResponseEntity.status(200).body(token);
//
//        response.setContentType("application/json");
//        response.getWriter().write(Objects.requireNonNull(responseEntity.getBody()));
        response.sendRedirect("http://localhost:3003/login?token=" + token);
    }
}

