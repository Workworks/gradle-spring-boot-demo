package org.kfaino.gradlespringbootdemo.transaction.repository;

import org.kfaino.gradlespringbootdemo.transaction.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity, Long> {
}