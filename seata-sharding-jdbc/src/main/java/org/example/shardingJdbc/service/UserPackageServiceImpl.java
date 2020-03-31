package org.example.shardingJdbc.service;

import org.example.shardingJdbc.dao.TUserPackageMapper;
import org.example.shardingJdbc.entity.TUserPackage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class UserPackageServiceImpl implements UserPackageService {

    @Resource
    private TUserPackageMapper tUserPackageMapper;

    @Override
    public boolean addPackageItem(TUserPackage userPackage) {
        if (userPackage == null) return false;
        return tUserPackageMapper.insert(userPackage) == 1;
    }

    @Override
    public boolean addPackageItems(Collection<TUserPackage> userPackages) {
        if (CollectionUtils.isEmpty(userPackages)) return false;
        final int expCount = userPackages.size();
        int realCount = 0;
        for (TUserPackage userPackage : userPackages) {
            if (userPackage == null) continue;
            realCount += tUserPackageMapper.insert(userPackage);
        }
        return realCount == expCount;
    }
}
