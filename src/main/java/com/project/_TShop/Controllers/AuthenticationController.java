package com.project._TShop.Controllers;

import com.project._TShop.Entities.Account;
import com.project._TShop.Request.AuthenticationRequest;
import com.project._TShop.Request.ChangePasswordReq;
import com.project._TShop.Request.FogotPasswordRequest;
import com.project._TShop.Request.RegisterRequest;
import com.project._TShop.Request.ResetPasswordRequest;
import com.project._TShop.Response.AuthenticationResponse;
import com.project._TShop.Response.Response;
import com.project._TShop.Services.AccountService;
import com.project._TShop.Services.AuthenticationService;
import com.project._TShop.Services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AccountService accountService;

    private final EmailService emailService;


    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request,HttpServletRequest req
    ) throws MessagingException, UnsupportedEncodingException {
        Response response = authenticationService.register(request, req);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/verify")
    public ResponseEntity<?> verifyAccount(@RequestParam("code") String code) {
        Response response = accountService.isValidRegistrationToken(code);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PostMapping("/fogot-password")
    public ResponseEntity<?> fogotPassword(
            @RequestBody FogotPasswordRequest request, HttpServletRequest req
    ) throws MessagingException, UnsupportedEncodingException {
        Response response = authenticationService.updateResetPasswordToken(request, req);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPasswordForm(@RequestBody ResetPasswordRequest request){
       Response response = authenticationService.updatePassword(request);
       return ResponseEntity.status(response.getStatus()).body(response);

    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        Response response = authenticationService.authenticate(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
