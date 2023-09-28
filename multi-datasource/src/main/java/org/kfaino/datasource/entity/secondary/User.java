package org.kfaino.datasource.entity.secondary;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
// 使用动态数据源不用配置schema
//@Table(name = "users", schema = "secondary")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
}


