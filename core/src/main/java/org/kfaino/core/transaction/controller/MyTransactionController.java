package org.kfaino.core.transaction.controller;

import jakarta.validation.Valid;
import org.kfaino.core.transaction.entity.MyEntity;
import org.kfaino.core.transaction.service.MyService;
import org.kfaino.core.transaction.dto.MyEntityDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("transaction")
public class MyTransactionController {

    @Autowired
    private MyService myService;

    @PostMapping("/create")
    public ResponseEntity<String> createEntity(@Valid @RequestBody MyEntityDTO myEntityDTO) {
        MyEntity myEntity = new MyEntity();
        BeanUtils.copyProperties(myEntityDTO,myEntity);

        myService.createEntity(myEntity);
        return new ResponseEntity<>("Entity has been created successfully! myEntity: " + myEntityDTO, HttpStatus.CREATED);
    }


}
