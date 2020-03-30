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
    public void addUserRecord(TUser record) {
        tUserMapper.insert(record);
    }
}
