package org.example.shardingJdbc.service;

import org.example.shardingJdbc.dao.TUserMapper;
import org.example.shardingJdbc.entity.TUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public boolean addUserRecord(TUser record) {
        return tUserMapper.insert(record) == 1;
    }
}
