package org.example.business.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.AccountAdaptor;
import org.example.business.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Service(version = "${service.dubbo.version.account}")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountAdaptor accountAdaptor;

    private static final int MIN_UPDATE_PARAM_MONEY = 0;
    private static final int UPDATE_ACCOUNT_ROW_COUNT = 1;

    @Override
    public Boolean debit(String userId, Integer money) {

        if (StringUtils.isEmpty(userId) || money == null || money < MIN_UPDATE_PARAM_MONEY) {
            return false;
        }

        Account account = accountAdaptor.queryAccountById(userId);
        if (account == null || account.getMoney() < money) {
            return false;
        }

        if (money == MIN_UPDATE_PARAM_MONEY) {
            return true;
        }

        final int resultCount = accountAdaptor.updateUserBalance(userId, money);
        return resultCount == UPDATE_ACCOUNT_ROW_COUNT;
    }
}
