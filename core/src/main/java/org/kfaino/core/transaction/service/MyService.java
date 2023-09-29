package org.kfaino.core.transaction.service;


import org.kfaino.core.transaction.entity.MyEntity;
import org.kfaino.core.transaction.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    public MyService(PlatformTransactionManager transactionManager, MyRepository myRepository) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.myRepository = myRepository;

        // 定制事务属性
        this.transactionTemplate.setPropagationBehavior(Propagation.REQUIRES_NEW.value());
        this.transactionTemplate.setIsolationLevel(Isolation.DEFAULT.value());
        this.transactionTemplate.setTimeout(30); // 设置超时时间，单位为秒
    }

    // 编程式事务管理实现
    public void createEntityByTemplate(MyEntity myEntity) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                myRepository.save(myEntity);
            }
        });
    }


    @Autowired
    private PlatformTransactionManager transactionManager;

    public void createEntityByTransactionManager(MyEntity myEntity) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            myRepository.save(myEntity);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }



    @Transactional(transactionManager = "transactionManager",propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30)
    public void createEntity(MyEntity myEntity) {
        myRepository.save(myEntity);
    }

}
