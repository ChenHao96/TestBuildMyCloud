package org.example.business.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.AccountAdaptor;
import org.example.business.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Component
@Service(version = "${service.dubbo.version.account}")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountAdaptor accountAdaptor;

    @Override
    public boolean debit(String userId, int money) {
        if (StringUtils.isEmpty(userId) || money < 0) return false;
        Account account = accountAdaptor.queryAccountById(userId);
        if (account == null || account.getMoney() < money) return false;
        if (money == 0) return true;
        return accountAdaptor.updateUserBalance(userId, money) == 1;
    }
}
