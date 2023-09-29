package org.kfaino.datasource.service;

import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.aspectj.weaver.ast.Or;
import org.kfaino.datasource.dto.OrderDTO;
import org.kfaino.datasource.dto.UserDTO;
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

    @Resource
    private UserService userService;

    /**
     * 该实例无法无法做到orderService.createOrder(orderDTO);的回滚操作
     * @param userOrderDTO
     * @return
     */
    @Transactional("transactionManager")
    public User createUserAndOrder(UserOrderDTO userOrderDTO) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(userOrderDTO, orderDTO);
        orderService.createOrder(orderDTO);
        // 报错
        int i = 1/0;
        User user = new User();
        BeanUtils.copyProperties(userOrderDTO, user);
        userRepository.save(user);
        return user;
    }


    @GlobalTransactional
    public void createUserAndOrderByGlobalTransaction(UserOrderDTO userOrderDTO) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(userOrderDTO, orderDTO);
        orderService.createOrder(orderDTO);
        // 报错
        int i = 1/0;

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userOrderDTO, userDTO);
        userService.createUser(userDTO);
    }



}
