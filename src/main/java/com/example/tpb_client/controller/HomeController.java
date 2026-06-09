package com.example.tpb_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "<h1>TPB E-Banking</h1>" +
                "<p>Chào mừng quý khách. Vui lòng đăng nhập để xem số dư.</p>" +
                "<a href='/dashboard' style='padding:10px; background:purple; color:white; text-decoration:none; border-radius:5px;'>Đăng nhập bằng VNeID</a>";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OidcUser oidcUser) {
        return String.format(
                "<h2>Hệ thống quản lý TPB</h2>" +
                        "<p>✅ Đăng nhập thành công qua hệ thống SSO VNeID!</p>" +
                        "<hr>" +
                        "<p><b>Họ và tên công dân:</b> %s</p>" +
                        "<p><b>Mã định danh (Username):</b> %s</p>" +
                        "<p><b>Email:</b> %s</p>",
                oidcUser.getFullName(),
                oidcUser.getPreferredUsername(),
                oidcUser.getEmail() != null ? oidcUser.getEmail() : "Chưa cập nhật"
        );
    }
}
