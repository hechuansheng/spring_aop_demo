package org.hechuansheng.demo.aop.controller;

import org.springframework.stereotype.Controller;

/**
 * @author : hechuansheng
 * @date : 2021/4/20 10:24
 * @description :
 */
@Controller
public class UserController {

    public void login(String userName, String password){
        System.out.println("login request ==> username: " + userName + ", password: " + password);
    }

    public String refreshToken(String token) {
        System.out.println("refreshToken request ==> token: " + token);

        return "new token";
    }

    public void loginOut() {
        System.out.println("loginOut request====>");
        throw new RuntimeException("123");
    }
}
