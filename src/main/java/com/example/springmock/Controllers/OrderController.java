package com.example.springmock.Controllers;

import com.example.springmock.Models.Order;
import com.example.springmock.Models.Product;
import com.example.springmock.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order)
    {
           return orderService.addOrder(order);
    }

    @GetMapping("/maxOrderProduct")
    public Product mostOrderedProduct()
    {
        return orderService.mostOrderedProduct();
    }
}
