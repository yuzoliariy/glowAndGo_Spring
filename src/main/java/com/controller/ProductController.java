package com.controller;

import com.model.Product;
import com.model.ProductType;
import com.service.interfaces.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = "/getProductTypes")
    public String productTypeList(final Model model) {
        final List<ProductType> productTypeList = productService.getAllTypesOfProducts();

        model.addAttribute("categories", productTypeList);
        return "category";
    }


    @GetMapping(value = "/products")
    @ResponseBody
    public ResponseEntity<List<Product>> getProductsByType(@RequestParam("typeId") final int typeId) {
        return ResponseEntity.ok(productService.getProductsByType(typeId));

    }
}
