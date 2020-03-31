package org.example.shardingJdbc.service;

import org.example.shardingJdbc.entity.TUser;
import org.example.shardingJdbc.entity.TUserPackage;

public interface BusinessService {

    boolean addUserPackage(TUser user, TUserPackage userPackage);
}
