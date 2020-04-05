package org.example.shardingJdbc.service;

import org.example.shardingJdbc.entity.TUser;

public interface UserService {

    boolean addUserRecord(TUser record);
}
