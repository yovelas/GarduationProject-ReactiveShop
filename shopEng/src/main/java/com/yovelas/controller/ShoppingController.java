package com.yovelas.controller;

import com.yovelas.dao.GoodsDao;
import com.yovelas.service.GoodsService;
import com.yovelas.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @CrossOrigin
    @GetMapping()
    List allShopping() throws IllegalAccessException {
        return shoppingService.selectAllShopping();
    }

}
