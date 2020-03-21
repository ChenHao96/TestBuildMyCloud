package org.example.business.adaptor;

import org.example.business.model.Account;

public interface AccountAdaptor {

    Account queryAccountById(String userId);

    int updateUserBalance(String userId, int money);
}
