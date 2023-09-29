package org.kfaino.datasource.service;

import jakarta.annotation.Resource;
import org.kfaino.datasource.annotation.DataSource;
import org.kfaino.datasource.dto.OrderDTO;
import org.kfaino.datasource.entity.secondary.Order;
import org.kfaino.datasource.repository.secondary.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;


    @DataSource("secondary")
    @Transactional("secondaryTransactionManager")
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        return orderRepository.save(order);
    }
}
