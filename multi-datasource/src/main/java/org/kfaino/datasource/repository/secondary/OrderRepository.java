package org.kfaino.datasource.repository.secondary;

import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.entity.secondary.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}