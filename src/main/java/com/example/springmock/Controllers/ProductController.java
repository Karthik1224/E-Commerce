package com.example.springmock.Controllers;

import com.example.springmock.Models.Product;
import com.example.springmock.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

       @Autowired
       private ProductService productService;
       @PostMapping("/addProduct")
       public String addProduct(@RequestBody Product product)
       {
           return productService.addProduct(product);
       }


       @GetMapping("/maxproduct")
       public Product getMaxPriceProduct(@RequestParam String category)
       {
             return productService.getMaxPriceProduct(category);
       }


}
