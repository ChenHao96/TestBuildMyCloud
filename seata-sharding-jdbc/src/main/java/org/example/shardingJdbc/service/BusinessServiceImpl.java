package org.example.shardingJdbc.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.shardingJdbc.entity.TUser;
import org.example.shardingJdbc.entity.TUserPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final UserService userService;

    private final UserPackageService userPackageService;

    @Autowired
    public BusinessServiceImpl(UserPackageService userPackageService, UserService userService) {
        this.userPackageService = userPackageService;
        this.userService = userService;
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "shardingJdbc-gts-seata-example", rollbackFor = Exception.class)
    public boolean addUserPackage(TUser user, TUserPackage userPackage) {
        user.setUId(null);
        boolean addUser = userService.addUserRecord(user);
        userPackage.setUId(user.getUId());
        boolean addPackage = userPackageService.addPackageItem(userPackage);
        if (addUser && addPackage) return true;
        throw new IllegalArgumentException("数据库修改失败!");
    }
}
