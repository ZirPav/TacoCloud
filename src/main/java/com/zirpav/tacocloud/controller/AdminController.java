package com.zirpav.tacocloud.controller;

import com.zirpav.tacocloud.service.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public final OrderAdminService orderAdminService;

    @Autowired
    public AdminController(final OrderAdminService orderAdminService) {
        this.orderAdminService = orderAdminService;
    }

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        orderAdminService.deleteAllOrders();
        return "/redirect:/admin";
    }
}
