package org.example.business.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.business.model.Account;

public interface AccountMapper extends BaseMapper<Account> {

    int updateUserBalance(String userId, int money);
}
