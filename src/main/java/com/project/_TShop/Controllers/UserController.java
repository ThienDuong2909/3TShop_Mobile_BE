package com.project._TShop.Controllers;

import com.project._TShop.Request.AuthenticationRequest;
import com.project._TShop.Request.FogotPasswordRequest;
import com.project._TShop.Request.RegisterRequest;
import com.project._TShop.Request.ResetPasswordRequest;
import com.project._TShop.Response.Response;
import com.project._TShop.Services.AccountService;
import com.project._TShop.Services.AuthenticationService;
import com.project._TShop.Services.EmailService;
import com.project._TShop.Services.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService userService;


    @GetMapping("/get-user-info")
    public ResponseEntity<?> getUserInfo(){
        Response response = userService.getUserInfo();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/get-user-information")
    public ResponseEntity<Response> getUserInformation(){
        Response response = userService.getUserInfoCustomer();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
