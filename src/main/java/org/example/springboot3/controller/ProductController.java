package org.example.springboot3.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboot3.entity.Product;
import org.example.springboot3.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kaikai
 * @since 2026-04-23
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    private List<Product> list() {
        return productService.list();
    }
}
