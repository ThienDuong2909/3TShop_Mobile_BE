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
        System.out.print("Lấy thông tin");
        Response response = userService.getUserInfo();
        System.out.print("Lấy thông tin: " + response);
        System.out.print("Lấy thông tin: " + ResponseEntity.status(response.getStatus()).body(response));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
