
package com.controller;

import com.model.Product;
import com.model.User;
import com.service.interfaces.ProductService;
import com.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/basket")
public class BasketController {
    private final UserService userService;
    private final ProductService productService;


    public BasketController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping
    public String getProductList(Model model, HttpSession session) {
        final int userId = (int) session.getAttribute("userId");

        final User userInfo = userService.get(userId);

        final List<Product> list = userInfo.getProductList();

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("productList", list);

        return "cartList";
    }


    @PostMapping
    public ResponseEntity addProductToCart(@RequestParam("productId") final String productId, HttpSession session) {
        final int userId = (int) session.getAttribute("userId");

        productService.addProductToCart(userId, Integer.parseInt(productId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteFromCart(@RequestParam("productId") final Integer productId, final HttpSession session) {
        final int userId = (int) session.getAttribute("userId");
        productService.deleteFromCart(productId, userId);
        return ResponseEntity.ok().build();
    }
}
