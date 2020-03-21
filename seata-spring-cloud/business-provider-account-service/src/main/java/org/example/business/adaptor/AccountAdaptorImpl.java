package org.example.business.adaptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.business.dao.AccountMapper;
import org.example.business.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class AccountAdaptorImpl implements AccountAdaptor {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account queryAccountById(String userId) {
        if (StringUtils.isEmpty(userId)) return null;
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return accountMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateUserBalance(String userId, int money) {
        return accountMapper.updateUserBalance(userId,money);
    }
}
