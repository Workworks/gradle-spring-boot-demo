package org.kfaino.core.transaction.repository;

import org.kfaino.core.transaction.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity, Long> {
}