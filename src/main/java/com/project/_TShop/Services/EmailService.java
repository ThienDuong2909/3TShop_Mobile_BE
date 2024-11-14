package com.project._TShop.Services;

import com.project._TShop.Entities.Account;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public static String getSiteURL(HttpServletRequest req){
        String siteURL = req.getRequestURL().toString();
        return siteURL.replace(req.getServletPath(),""); //remove /forgot-password in localhost/forgotpassword
    }
    public void sendVerificationEmail(Account account, HttpServletRequest req) throws MessagingException, UnsupportedEncodingException {
        String siteURL = getSiteURL(req);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("khinthij@gmail.com", "3TSHOP");
        helper.setTo(account.getEmail());
//        String verifyURL = siteURL + "/verify?code=" + account.getRegistrationToken();
        String verifyURL = "http://localhost:3003/verify?code=" + account.getRegistrationToken();

        System.out.println(verifyURL);

        String subject = "Xác nhận đăng kí tài khoản";
        String content = "<p>Xin chào, </p>"
                + "<p>Hãy nhấn vào đường dẫn bên dưới để xác nhận .</p>"
                + "<p><b><a href=\"" + verifyURL + "\">Xác nhận đăng kí<a/></b></p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

    public void sendEmailToResetPassword(Account account, HttpServletRequest req) throws MessagingException, UnsupportedEncodingException {
        String siteURL = getSiteURL(req);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("khinthij@gmail.com", "3TSHOP");
        helper.setTo(account.getEmail());
//        String verifyURL = siteURL + "/reset-password?code=" + account.getResetPasswordToken();
        String verifyURL = "http://localhost:3003/reset-password?code=" + account.getResetPasswordToken();

        System.out.println(verifyURL);

        String subject = "Đặt lại mật khẩu";
        String content = "<p>Xin chào, </p>"
                + "<p>Hãy nhấn vào đường dẫn bên dưới để đổi mật khẩu mới .</p>"
                + "<p><b><a href=\"" + verifyURL + "\">Nhấn để đặt lại mật khẩu<a/></b></p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }
}
