package com.yovelas.controller;

import com.yovelas.entity.Order;
import com.yovelas.service.OrderService;
import com.yovelas.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ShoppingService shoppingService;

    @Autowired
    OrderService orderService;

    @CrossOrigin
    @PostMapping()
    Object AddOneOrder(@RequestBody Order order){
        System.out.println(order);
        return orderService.insertOneUserOrders(order);
    }

}
