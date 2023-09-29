package org.kfaino.datasource.repository.primary;

import org.kfaino.datasource.entity.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}