package org.example.shardingJdbc.service;

import org.example.shardingJdbc.dao.TUserPackageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserPackageServiceImpl implements UserPackageService {

    @Resource
    private TUserPackageMapper tUserPackageMapper;
}
