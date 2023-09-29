package org.kfaino.datasource.service;

import jakarta.annotation.Resource;
import org.aspectj.weaver.ast.Or;
import org.kfaino.datasource.dto.OrderDTO;
import org.kfaino.datasource.dto.UserOrderDTO;
import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.entity.secondary.Order;
import org.kfaino.datasource.repository.primary.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserOrderService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private OrderService orderService;

    @Transactional("transactionManager")
    public User createUserAndOrder(UserOrderDTO userOrderDTO) {
        User user = new User();
        BeanUtils.copyProperties(userOrderDTO, user);
        userRepository.save(user);

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(userOrderDTO, orderDTO);
        orderService.createOrder(orderDTO);
        return user;
    }
}
