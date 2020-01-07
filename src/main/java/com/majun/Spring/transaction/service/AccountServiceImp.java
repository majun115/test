package com.majun.Spring.transaction.service;

import com.majun.Spring.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountDao accountDao;
    //事务模板
    //@Autowired
   // private TransactionTemplate transactionTemplate;
    //转账操作
    @Override
    public void transferMoney(String name, String name2, double d) {
     /*   transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountDao.outMoney(name,d);
                System.out.println(1/0);
                accountDao.inMoney(name2,d);
            }
        });*/
        accountDao.outMoney(name,d);
        System.out.println(1/0);
        accountDao.inMoney(name2,d);

    }

/*    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }*/

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



}
