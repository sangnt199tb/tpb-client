package com.example.tpb_client.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return """
                <!doctype html>
                <html lang="vi">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Đăng nhập TPB E-Banking</title>
                    <style>
                        :root {
                            --tpb-purple: #6f2dbd;
                            --tpb-violet: #8f3ffc;
                            --tpb-blue: #2f7df4;
                            --tpb-ink: #202437;
                            --tpb-muted: #6d7484;
                            --tpb-border: #e7eaf0;
                            --tpb-bg: #f5f7fb;
                        }

                        * {
                            box-sizing: border-box;
                        }

                        body {
                            margin: 0;
                            min-height: 100vh;
                            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Arial, sans-serif;
                            color: var(--tpb-ink);
                            background:
                                    radial-gradient(circle at 16% 18%, rgba(111, 45, 189, 0.13), transparent 30%),
                                    radial-gradient(circle at 84% 78%, rgba(47, 125, 244, 0.13), transparent 28%),
                                    linear-gradient(135deg, #ffffff 0%, var(--tpb-bg) 100%);
                        }

                        .login-page {
                            min-height: 100vh;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            padding: 32px 18px;
                        }

                        .login-card {
                            width: min(100%, 392px);
                            padding: 34px 32px 28px;
                            border: 1px solid rgba(231, 234, 240, 0.9);
                            border-radius: 8px;
                            background: rgba(255, 255, 255, 0.96);
                            box-shadow: 0 18px 45px rgba(31, 39, 61, 0.14);
                        }

                        .brand {
                            display: flex;
                            justify-content: center;
                            margin-bottom: 20px;
                        }

                        .brand-mark {
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            color: var(--tpb-purple);
                            font-size: 26px;
                            font-weight: 800;
                            letter-spacing: 0;
                        }

                        .brand-mark span {
                            color: var(--tpb-blue);
                        }

                        h1 {
                            margin: 0;
                            font-size: 23px;
                            line-height: 1.25;
                            text-align: center;
                        }

                        .intro {
                            max-width: 292px;
                            margin: 12px auto 24px;
                            color: var(--tpb-muted);
                            font-size: 14px;
                            line-height: 1.55;
                            text-align: center;
                        }

                        .field-group {
                            display: grid;
                            gap: 14px;
                        }

                        label {
                            display: block;
                            margin-bottom: 7px;
                            color: #3d4352;
                            font-size: 13px;
                            font-weight: 700;
                        }

                        .input-wrap {
                            position: relative;
                        }

                        input[type="text"],
                        input[type="password"] {
                            width: 100%;
                            height: 46px;
                            border: 1px solid var(--tpb-border);
                            border-radius: 6px;
                            padding: 0 44px 0 14px;
                            color: var(--tpb-ink);
                            font-size: 14px;
                            outline: none;
                            background: #ffffff;
                            transition: border-color 0.18s ease, box-shadow 0.18s ease;
                        }

                        input:focus {
                            border-color: var(--tpb-blue);
                            box-shadow: 0 0 0 4px rgba(47, 125, 244, 0.13);
                        }

                        .toggle-password {
                            position: absolute;
                            top: 50%;
                            right: 10px;
                            width: 30px;
                            height: 30px;
                            display: inline-flex;
                            align-items: center;
                            justify-content: center;
                            border: 0;
                            border-radius: 6px;
                            color: #7a8190;
                            background: transparent;
                            cursor: pointer;
                            transform: translateY(-50%);
                        }

                        .toggle-password:hover {
                            background: #f0f3f8;
                            color: var(--tpb-purple);
                        }

                        .eye-icon {
                            position: relative;
                            width: 18px;
                            height: 12px;
                            border: 2px solid currentColor;
                            border-radius: 100% 0;
                            transform: rotate(45deg);
                        }

                        .eye-icon::after {
                            content: "";
                            position: absolute;
                            top: 50%;
                            left: 50%;
                            width: 6px;
                            height: 6px;
                            border-radius: 50%;
                            background: currentColor;
                            transform: translate(-50%, -50%);
                        }

                        .form-options {
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            gap: 16px;
                            margin: 16px 0 18px;
                            font-size: 13px;
                        }

                        .remember {
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            color: #4e5667;
                            cursor: pointer;
                        }

                        .remember input {
                            width: 15px;
                            height: 15px;
                            accent-color: var(--tpb-purple);
                        }

                        a {
                            color: var(--tpb-purple);
                            text-decoration: none;
                            font-weight: 700;
                        }

                        a:hover {
                            color: var(--tpb-blue);
                            text-decoration: underline;
                        }

                        .login-button {
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            width: 100%;
                            height: 46px;
                            border: 0;
                            border-radius: 6px;
                            color: #ffffff;
                            background: linear-gradient(90deg, var(--tpb-purple), var(--tpb-blue));
                            font-size: 15px;
                            font-weight: 800;
                            text-decoration: none;
                            cursor: pointer;
                            box-shadow: 0 12px 22px rgba(111, 45, 189, 0.24);
                            transition: transform 0.18s ease, box-shadow 0.18s ease;
                        }

                        .login-button:hover {
                            transform: translateY(-1px);
                            box-shadow: 0 16px 26px rgba(47, 125, 244, 0.27);
                            text-decoration: none;
                            color: #ffffff;
                        }

                        .divider {
                            display: flex;
                            align-items: center;
                            gap: 12px;
                            margin: 26px 0 16px;
                            color: #9aa1ad;
                            font-size: 12px;
                            text-align: center;
                        }

                        .divider::before,
                        .divider::after {
                            content: "";
                            flex: 1;
                            height: 1px;
                            background: var(--tpb-border);
                        }

                        .sso-list {
                            display: grid;
                            grid-template-columns: repeat(3, minmax(0, 1fr));
                            gap: 10px;
                        }

                        .sso-button {
                            min-height: 74px;
                            display: grid;
                            align-items: center;
                            align-content: center;
                            justify-content: center;
                            justify-items: center;
                            gap: 8px;
                            border: 1px solid var(--tpb-border);
                            border-radius: 8px;
                            color: #323848;
                            font-size: 13px;
                            font-weight: 800;
                            text-decoration: none;
                            background: #ffffff;
                            box-shadow: 0 6px 14px rgba(31, 39, 61, 0.08);
                            transition: transform 0.18s ease, border-color 0.18s ease, color 0.18s ease;
                        }

                        .sso-button:hover {
                            transform: translateY(-2px);
                            border-color: #cfe0ff;
                            color: var(--tpb-blue);
                            text-decoration: none;
                        }

                        .method-icon {
                            width: 34px;
                            height: 34px;
                            display: inline-flex;
                            align-items: center;
                            justify-content: center;
                            border-radius: 50%;
                            color: #ffffff;
                            background: linear-gradient(135deg, var(--tpb-purple), var(--tpb-blue));
                            font-size: 12px;
                            font-weight: 800;
                        }

                        .face-scan {
                            position: relative;
                            width: 24px;
                            height: 24px;
                            border: 2px solid currentColor;
                            border-radius: 8px;
                        }

                        .face-scan::before,
                        .face-scan::after {
                            content: "";
                            position: absolute;
                            background: currentColor;
                        }

                        .face-scan::before {
                            width: 4px;
                            height: 4px;
                            top: 7px;
                            left: 6px;
                            border-radius: 50%;
                            box-shadow: 8px 0 0 currentColor;
                        }

                        .face-scan::after {
                            width: 10px;
                            height: 2px;
                            left: 6px;
                            bottom: 6px;
                            border-radius: 999px;
                        }

                        .help-row {
                            margin-top: 24px;
                            color: #7a8190;
                            font-size: 12px;
                            text-align: center;
                        }

                        @media (max-width: 480px) {
                            .login-page {
                                align-items: flex-start;
                                padding-top: 24px;
                            }

                            .login-card {
                                padding: 28px 20px 24px;
                            }

                            h1 {
                                font-size: 21px;
                            }

                            .form-options {
                                align-items: flex-start;
                                flex-direction: column;
                                gap: 10px;
                            }

                            .sso-list {
                                grid-template-columns: 1fr;
                            }
                        }
                    </style>
                </head>
                <body>
                    <main class="login-page">
                        <section class="login-card" aria-label="Đăng nhập TPB E-Banking">
                            <div class="brand" aria-hidden="true">
                                <div class="brand-mark">TP<span>Bank</span></div>
                            </div>
                            <h1>Đăng nhập TPB E-Banking</h1>
                            <p class="intro">Vui lòng đăng nhập để truy cập tài khoản và sử dụng dịch vụ ngân hàng số an toàn.</p>

                            <form action="/dashboard" method="get">
                                <div class="field-group">
                                    <div>
                                        <label for="username">Tên đăng nhập hoặc email</label>
                                        <div class="input-wrap">
                                            <input id="username" name="username" type="text" autocomplete="username" placeholder="Nhập tên đăng nhập">
                                        </div>
                                    </div>

                                    <div>
                                        <label for="password">Mật khẩu</label>
                                        <div class="input-wrap">
                                            <input id="password" name="password" type="password" autocomplete="current-password" placeholder="Nhập mật khẩu">
                                            <button class="toggle-password" type="button" aria-label="Hiện mật khẩu" onclick="togglePassword()">
                                                <span class="eye-icon" aria-hidden="true"></span>
                                            </button>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-options">
                                    <label class="remember" for="remember">
                                        <input id="remember" name="remember" type="checkbox">
                                        Ghi nhớ đăng nhập
                                    </label>
                                    <a href="/dashboard">Quên mật khẩu?</a>
                                </div>

                                <button class="login-button" type="submit">Đăng nhập</button>
                            </form>

                            <div class="divider">Hoặc sử dụng phương thức khác</div>
                            <div class="sso-list" aria-label="Phương thức đăng nhập khác">
                                <a class="sso-button" href="/dashboard" aria-label="Face ID">
                                    <span class="method-icon"><span class="face-scan" aria-hidden="true"></span></span>
                                    Face ID
                                </a>
                                <a class="sso-button" href="/dashboard" aria-label="VNeID">
                                    <span class="method-icon">ID</span>
                                    VNeID
                                </a>
                                <a class="sso-button" href="/dashboard" aria-label="Smart OTP">
                                    <span class="method-icon">OTP</span>
                                    Smart OTP
                                </a>
                            </div>

                            <div class="help-row">
                                <a href="/dashboard">Trợ giúp</a> &nbsp;|&nbsp; Tiếng Việt
                            </div>
                        </section>
                    </main>

                    <script>
                        function togglePassword() {
                            const password = document.getElementById("password");
                            const button = document.querySelector(".toggle-password");
                            const isHidden = password.type === "password";
                            password.type = isHidden ? "text" : "password";
                            button.setAttribute("aria-label", isHidden ? "Ẩn mật khẩu" : "Hiện mật khẩu");
                        }
                    </script>
                </body>
                </html>
                """;
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OidcUser oidcUser) {
        String fullName = escapeHtml(oidcUser.getFullName() != null ? oidcUser.getFullName() : "Chưa cập nhật");
        String username = escapeHtml(oidcUser.getPreferredUsername() != null ? oidcUser.getPreferredUsername() : "Chưa cập nhật");
        String email = escapeHtml(oidcUser.getEmail() != null ? oidcUser.getEmail() : "Chưa cập nhật");

        return """
                <!doctype html>
                <html lang="vi">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Thông tin tài khoản TPB</title>
                    <style>
                        :root {
                            --tpb-purple: #6f2dbd;
                            --tpb-blue: #2f7df4;
                            --ink: #202437;
                            --muted: #747b8c;
                            --line: #e8ebf2;
                            --page: #f4f6f9;
                            --soft-blue: #edf4ff;
                            --soft-orange: #fff6ed;
                        }

                        * {
                            box-sizing: border-box;
                        }

                        body {
                            margin: 0;
                            min-height: 100vh;
                            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Arial, sans-serif;
                            color: var(--ink);
                            background: var(--page);
                        }

                        .account-shell {
                            min-height: 100vh;
                            display: grid;
                            grid-template-columns: 252px minmax(0, 1fr);
                        }

                        .sidebar {
                            border-right: 1px solid var(--line);
                            background: #ffffff;
                        }

                        .sidebar-header {
                            height: 70px;
                            display: flex;
                            align-items: center;
                            gap: 10px;
                            padding: 0 22px;
                            border-bottom: 1px solid var(--line);
                        }

                        .brand-mark {
                            color: var(--tpb-purple);
                            font-size: 20px;
                            font-weight: 800;
                        }

                        .brand-mark span {
                            color: var(--tpb-blue);
                        }

                        .brand-subtitle {
                            color: #4b5262;
                            font-size: 14px;
                            font-weight: 800;
                        }

                        .nav {
                            display: grid;
                            gap: 6px;
                            padding: 16px 10px;
                        }

                        .nav-group {
                            border-radius: 6px;
                        }

                        .nav-item {
                            display: flex;
                            align-items: center;
                            gap: 12px;
                            min-height: 42px;
                            padding: 0 14px;
                            border-radius: 6px;
                            color: #4f5667;
                            font-size: 14px;
                            font-weight: 700;
                            text-decoration: none;
                            cursor: default;
                        }

                        .nav-group:hover .nav-item,
                        .nav-group:focus-within .nav-item {
                            background: #f3f6fb;
                            color: var(--tpb-purple);
                        }

                        .nav-item.active {
                            color: #ffffff;
                            background: linear-gradient(90deg, var(--tpb-purple), var(--tpb-blue));
                        }

                        .nav-icon {
                            width: 24px;
                            height: 20px;
                            display: inline-flex;
                            align-items: center;
                            justify-content: center;
                            border: 1px solid currentColor;
                            border-radius: 5px;
                            font-size: 10px;
                            flex: 0 0 auto;
                        }

                        .subnav {
                            display: grid;
                            gap: 2px;
                            max-height: 0;
                            margin: 0 0 0 44px;
                            overflow: hidden;
                            opacity: 0;
                            transition: max-height 0.2s ease, opacity 0.2s ease, margin 0.2s ease;
                        }

                        .nav-group:hover .subnav,
                        .nav-group:focus-within .subnav {
                            max-height: 220px;
                            margin: 6px 0 10px 44px;
                            opacity: 1;
                        }

                        .subnav a {
                            padding: 8px 0;
                            color: #7a8190;
                            font-size: 13px;
                            font-weight: 600;
                            text-decoration: none;
                        }

                        .subnav a:hover,
                        .subnav a.current {
                            color: var(--tpb-blue);
                        }

                        .chevron {
                            margin-left: auto;
                            color: currentColor;
                            font-size: 13px;
                            transition: transform 0.2s ease;
                        }

                        .nav-group:hover .chevron,
                        .nav-group:focus-within .chevron {
                            transform: rotate(90deg);
                        }

                        .main {
                            min-width: 0;
                            background:
                                    linear-gradient(180deg, rgba(255, 255, 255, 0.92), rgba(244, 246, 249, 0.94)),
                                    radial-gradient(circle at 70% 8%, rgba(47, 125, 244, 0.12), transparent 28%);
                        }

                        .topbar {
                            height: 70px;
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            padding: 0 30px;
                            border-bottom: 1px solid var(--line);
                            background: rgba(255, 255, 255, 0.84);
                        }

                        .topbar-title {
                            margin: 0;
                            font-size: 18px;
                            font-weight: 800;
                        }

                        .user-chip {
                            display: inline-flex;
                            align-items: center;
                            gap: 10px;
                            padding: 8px 12px;
                            border: 1px solid var(--line);
                            border-radius: 999px;
                            background: #ffffff;
                            color: #4b5262;
                            font-size: 13px;
                            font-weight: 700;
                        }

                        .avatar {
                            width: 32px;
                            height: 32px;
                            display: inline-flex;
                            align-items: center;
                            justify-content: center;
                            border-radius: 50%;
                            color: #ffffff;
                            background: linear-gradient(135deg, var(--tpb-purple), var(--tpb-blue));
                            font-weight: 800;
                        }

                        .content {
                            width: min(100%, 980px);
                            margin: 0 auto;
                            padding: 28px 28px 48px;
                        }

                        .progress-panel {
                            display: grid;
                            gap: 14px;
                            padding: 24px;
                            border: 1px solid #ffe8d1;
                            border-radius: 8px;
                            background: var(--soft-orange);
                            color: #5b6372;
                        }

                        .progress-copy {
                            margin: 0;
                            font-size: 14px;
                            line-height: 1.55;
                        }

                        .progress-task {
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            gap: 16px;
                            padding: 13px 16px;
                            border: 1px solid #f1d8bd;
                            border-radius: 6px;
                            background: #ffffff;
                            font-size: 14px;
                            font-weight: 700;
                        }

                        .progress-actions {
                            display: flex;
                            gap: 16px;
                        }

                        .ghost-link {
                            border: 0;
                            color: #8c94a3;
                            background: transparent;
                            font: inherit;
                            font-weight: 800;
                            cursor: pointer;
                        }

                        .primary-link {
                            color: var(--tpb-blue);
                            text-decoration: none;
                            font-weight: 800;
                        }

                        .section-heading {
                            margin: 28px 0 20px;
                            text-align: center;
                        }

                        .section-heading h1 {
                            margin: 0;
                            font-size: 22px;
                        }

                        .section-heading p {
                            margin: 8px 0 0;
                            color: var(--muted);
                            font-size: 14px;
                        }

                        .info-grid {
                            display: grid;
                            gap: 18px;
                        }

                        .info-card {
                            border: 1px solid var(--line);
                            border-radius: 8px;
                            background: #ffffff;
                            box-shadow: 0 10px 28px rgba(31, 39, 61, 0.05);
                        }

                        .card-header {
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            padding: 20px 22px 6px;
                        }

                        .card-title {
                            margin: 0;
                            font-size: 17px;
                        }

                        .edit-link {
                            color: var(--tpb-blue);
                            font-size: 13px;
                            font-weight: 800;
                            text-decoration: none;
                        }

                        .info-row {
                            display: grid;
                            grid-template-columns: 180px minmax(0, 1fr) 120px;
                            gap: 16px;
                            min-height: 46px;
                            align-items: center;
                            margin: 0 22px;
                            border-bottom: 1px solid var(--line);
                            font-size: 14px;
                        }

                        .info-row:last-child {
                            border-bottom: 0;
                        }

                        .label {
                            color: var(--muted);
                            font-weight: 700;
                        }

                        .value {
                            min-width: 0;
                            color: #323848;
                            font-weight: 800;
                            overflow-wrap: anywhere;
                        }

                        .status {
                            color: #8c94a3;
                            font-size: 13px;
                            font-weight: 700;
                            text-align: right;
                        }

                        .success-badge {
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            margin-top: 18px;
                            padding: 10px 14px;
                            border: 1px solid #d8e7ff;
                            border-radius: 999px;
                            color: #315d9e;
                            background: var(--soft-blue);
                            font-size: 13px;
                            font-weight: 800;
                        }

                        .balance-grid {
                            display: grid;
                            grid-template-columns: repeat(3, minmax(0, 1fr));
                            gap: 16px;
                            margin-bottom: 18px;
                        }

                        .metric-card {
                            min-height: 132px;
                            display: grid;
                            align-content: space-between;
                            padding: 20px;
                            border: 1px solid var(--line);
                            border-radius: 8px;
                            background: #ffffff;
                            box-shadow: 0 10px 28px rgba(31, 39, 61, 0.05);
                        }

                        .metric-label {
                            color: var(--muted);
                            font-size: 13px;
                            font-weight: 800;
                        }

                        .metric-value {
                            margin-top: 10px;
                            color: #202437;
                            font-size: 26px;
                            font-weight: 800;
                        }

                        .metric-note {
                            color: #8c94a3;
                            font-size: 13px;
                            font-weight: 700;
                        }

                        .quick-actions {
                            display: grid;
                            grid-template-columns: repeat(4, minmax(0, 1fr));
                            gap: 12px;
                            margin-bottom: 18px;
                        }

                        .quick-action {
                            min-height: 88px;
                            display: grid;
                            gap: 8px;
                            align-content: center;
                            justify-items: center;
                            border: 1px solid var(--line);
                            border-radius: 8px;
                            color: #323848;
                            background: #ffffff;
                            font-size: 13px;
                            font-weight: 800;
                            text-decoration: none;
                        }

                        .quick-action:hover {
                            border-color: #cfe0ff;
                            color: var(--tpb-blue);
                            box-shadow: 0 12px 24px rgba(47, 125, 244, 0.1);
                        }

                        .action-icon {
                            width: 34px;
                            height: 34px;
                            display: inline-flex;
                            align-items: center;
                            justify-content: center;
                            border-radius: 50%;
                            color: #ffffff;
                            background: linear-gradient(135deg, var(--tpb-purple), var(--tpb-blue));
                            font-weight: 800;
                        }

                        @media (max-width: 860px) {
                            .account-shell {
                                grid-template-columns: 1fr;
                            }

                            .sidebar {
                                position: static;
                                border-right: 0;
                                border-bottom: 1px solid var(--line);
                            }

                            .nav {
                                display: flex;
                                gap: 8px;
                                overflow-x: auto;
                                padding: 12px;
                            }

                            .nav-group {
                                flex: 0 0 auto;
                            }

                            .nav-item {
                                white-space: nowrap;
                            }

                            .subnav {
                                display: none;
                            }

                            .topbar {
                                padding: 0 18px;
                            }

                            .content {
                                padding: 22px 16px 36px;
                            }

                            .balance-grid,
                            .quick-actions {
                                grid-template-columns: 1fr 1fr;
                            }
                        }

                        @media (max-width: 620px) {
                            .topbar {
                                height: auto;
                                align-items: flex-start;
                                flex-direction: column;
                                gap: 12px;
                                padding: 16px;
                            }

                            .progress-task,
                            .progress-actions {
                                align-items: flex-start;
                                flex-direction: column;
                            }

                            .info-row {
                                grid-template-columns: 1fr;
                                gap: 6px;
                                padding: 14px 0;
                            }

                            .status {
                                text-align: left;
                            }

                            .balance-grid,
                            .quick-actions {
                                grid-template-columns: 1fr;
                            }
                        }
                    </style>
                </head>
                <body>
                    <div class="account-shell">
                        <aside class="sidebar" aria-label="Điều hướng tài khoản">
                            <div class="sidebar-header">
                                <div class="brand-mark">TP<span>Bank</span></div>
                                <div class="brand-subtitle">Tài khoản</div>
                            </div>
                            <nav class="nav">
                                <div class="nav-group">
                                    <a class="nav-item active" href="/dashboard"><span class="nav-icon">TQ</span>Tổng quan<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a class="current" href="/dashboard">Tổng quan tài khoản</a>
                                        <a href="/dashboard">Tài khoản thanh toán</a>
                                        <a href="/dashboard">Số dư & giao dịch gần đây</a>
                                        <a href="/dashboard">Thông báo ngân hàng</a>
                                    </div>
                                </div>
                                <div class="nav-group">
                                    <a class="nav-item" href="/dashboard"><span class="nav-icon">GD</span>Giao dịch<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a href="/dashboard">Chuyển tiền</a>
                                        <a href="/dashboard">Thanh toán hóa đơn</a>
                                        <a href="/dashboard">Nạp tiền điện thoại</a>
                                        <a href="/dashboard">Quét mã QR</a>
                                        <a href="/dashboard">Lịch sử giao dịch</a>
                                    </div>
                                </div>
                                <div class="nav-group">
                                    <a class="nav-item" href="/dashboard"><span class="nav-icon">TH</span>Thẻ<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a href="/dashboard">Quản lý thẻ</a>
                                        <a href="/dashboard">Mở/khóa thẻ</a>
                                        <a href="/dashboard">Hạn mức thẻ</a>
                                        <a href="/dashboard">Sao kê thẻ</a>
                                    </div>
                                </div>
                                <div class="nav-group">
                                    <a class="nav-item" href="/dashboard"><span class="nav-icon">TV</span>Tiết kiệm & Vay<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a href="/dashboard">Sổ tiết kiệm</a>
                                        <a href="/dashboard">Mở tiết kiệm online</a>
                                        <a href="/dashboard">Khoản vay</a>
                                        <a href="/dashboard">Lịch trả nợ</a>
                                    </div>
                                </div>
                                <div class="nav-group">
                                    <a class="nav-item" href="/dashboard"><span class="nav-icon">BM</span>Bảo mật<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a href="/dashboard">Bảo mật tài khoản</a>
                                        <a href="/dashboard">Đổi mật khẩu</a>
                                        <a href="/dashboard">Xác thực OTP</a>
                                        <a href="/dashboard">Thiết bị đăng nhập</a>
                                        <a href="/dashboard">Cài đặt hạn mức giao dịch</a>
                                    </div>
                                </div>
                                <div class="nav-group">
                                    <a class="nav-item" href="/dashboard"><span class="nav-icon">HS</span>Hồ sơ<span class="chevron">&gt;</span></a>
                                    <div class="subnav">
                                        <a href="/dashboard">Thông tin cá nhân</a>
                                        <a href="/dashboard">Thông tin định danh</a>
                                        <a href="/dashboard">Địa chỉ liên hệ</a>
                                        <a href="/dashboard">Cài đặt tài khoản</a>
                                    </div>
                                </div>
                            </nav>
                        </aside>

                        <main class="main">
                            <header class="topbar">
                                <h2 class="topbar-title">Hệ thống quản lý TPB</h2>
                                <div class="user-chip">
                                    <span class="avatar">TP</span>
                                    <span>__USERNAME__</span>
                                </div>
                            </header>

                            <div class="content">
                                <section class="progress-panel" aria-label="Tiến độ cập nhật">
                                    <p class="progress-copy">Tài khoản của bạn đã đăng nhập an toàn qua SSO VNeID. Hãy kiểm tra thông báo bảo mật và xác nhận thông tin định danh định kỳ.</p>
                                    <div class="progress-task">
                                        <span>Gợi ý: bật xác thực OTP và kiểm tra thiết bị đăng nhập gần đây.</span>
                                        <div class="progress-actions">
                                            <button class="ghost-link" type="button">Để sau</button>
                                            <a class="primary-link" href="/dashboard">Kiểm tra ngay</a>
                                        </div>
                                    </div>
                                </section>

                                <section class="section-heading">
                                    <h1>Tổng quan tài khoản</h1>
                                    <p>Quản lý tài khoản, giao dịch và bảo mật ngân hàng số</p>
                                    <div class="success-badge">Đăng nhập thành công qua hệ thống SSO VNeID</div>
                                </section>

                                <section class="balance-grid" aria-label="Tổng quan số dư">
                                    <article class="metric-card">
                                        <div>
                                            <div class="metric-label">Số dư khả dụng</div>
                                            <div class="metric-value">128.500.000 VND</div>
                                        </div>
                                        <div class="metric-note">Tài khoản chính **** 2048</div>
                                    </article>
                                    <article class="metric-card">
                                        <div>
                                            <div class="metric-label">Tiết kiệm online</div>
                                            <div class="metric-value">75.000.000 VND</div>
                                        </div>
                                        <div class="metric-note">Lãi suất dự kiến 4.8%/năm</div>
                                    </article>
                                    <article class="metric-card">
                                        <div>
                                            <div class="metric-label">Hạn mức chuyển khoản</div>
                                            <div class="metric-value">300.000.000 VND</div>
                                        </div>
                                        <div class="metric-note">Còn lại hôm nay 300.000.000 VND</div>
                                    </article>
                                </section>

                                <section class="quick-actions" aria-label="Thao tác nhanh">
                                    <a class="quick-action" href="/dashboard"><span class="action-icon">CT</span>Chuyển tiền</a>
                                    <a class="quick-action" href="/dashboard"><span class="action-icon">QR</span>Quét mã QR</a>
                                    <a class="quick-action" href="/dashboard"><span class="action-icon">HD</span>Thanh toán hóa đơn</a>
                                    <a class="quick-action" href="/dashboard"><span class="action-icon">NT</span>Nạp điện thoại</a>
                                </section>

                                <section class="info-grid" aria-label="Thông tin tài khoản">
                                    <article class="info-card">
                                        <div class="card-header">
                                            <h2 class="card-title">Tài khoản thanh toán</h2>
                                            <a class="edit-link" href="/dashboard">Xem chi tiết</a>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Chủ tài khoản</div>
                                            <div class="value">__FULL_NAME__</div>
                                            <div class="status">Đã xác thực</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Số tài khoản</div>
                                            <div class="value">1903 2048 6688</div>
                                            <div class="status">Đang hoạt động</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Loại tài khoản</div>
                                            <div class="value">Tài khoản thanh toán VND</div>
                                            <div class="status">TPB E-Banking</div>
                                        </div>
                                    </article>

                                    <article class="info-card">
                                        <div class="card-header">
                                            <h2 class="card-title">Giao dịch gần đây</h2>
                                            <a class="edit-link" href="/dashboard">Xem tất cả</a>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Nhận tiền</div>
                                            <div class="value">+2.500.000 VND từ Nguyễn Minh Anh</div>
                                            <div class="status">Hôm nay</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Thanh toán</div>
                                            <div class="value">-850.000 VND hóa đơn điện</div>
                                            <div class="status">Hôm qua</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Chuyển khoản</div>
                                            <div class="value">-1.200.000 VND đến Trần Quốc Huy</div>
                                            <div class="status">10/06/2026</div>
                                        </div>
                                    </article>

                                    <article class="info-card">
                                        <div class="card-header">
                                            <h2 class="card-title">Thông báo bảo mật</h2>
                                            <a class="edit-link" href="/dashboard">Cài đặt</a>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Người dùng</div>
                                            <div class="value">__USERNAME__</div>
                                            <div class="status">SSO VNeID</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Email nhận cảnh báo</div>
                                            <div class="value">__EMAIL__</div>
                                            <div class="status">Đã xác thực</div>
                                        </div>
                                        <div class="info-row">
                                            <div class="label">Thiết bị đăng nhập</div>
                                            <div class="value">Chrome trên macOS</div>
                                            <div class="status">Vừa xong</div>
                                        </div>
                                    </article>
                                </section>
                            </div>
                        </main>
                    </div>
                </body>
                </html>
                """
                .replace("__FULL_NAME__", fullName)
                .replace("__USERNAME__", username)
                .replace("__EMAIL__", email);
    }

    private static String escapeHtml(String value) {
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
