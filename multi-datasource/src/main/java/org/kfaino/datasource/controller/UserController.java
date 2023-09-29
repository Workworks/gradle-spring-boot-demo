package org.kfaino.datasource.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.kfaino.datasource.dto.OrderDTO;
import org.kfaino.datasource.dto.UserDTO;
import org.kfaino.datasource.dto.UserOrderDTO;
import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.entity.secondary.Order;
import org.kfaino.datasource.service.OrderService;
import org.kfaino.datasource.service.UserOrderService;
import org.kfaino.datasource.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    @Resource
    private UserOrderService userOrderService;

    @GetMapping("/test")
    public String test() {
        return "Test Successful!";
    }


    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PostMapping("/createOrder")
    public Order createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }


    @PostMapping("/createMix")
    public User createMix(@Valid @RequestBody UserOrderDTO userOrderDTO) {
        return userOrderService.createUserAndOrder(userOrderDTO);
    }

    @PostMapping("/createMixGlobalTransaction")
    public void createMixByGlobalTransaction(@Valid @RequestBody UserOrderDTO userOrderDTO) {
        userOrderService.createUserAndOrderByGlobalTransaction(userOrderDTO);
    }
}
