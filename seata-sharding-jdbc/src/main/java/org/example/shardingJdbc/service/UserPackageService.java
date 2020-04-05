package org.example.shardingJdbc.service;

import org.example.shardingJdbc.entity.TUserPackage;

import java.util.Collection;

public interface UserPackageService {

    boolean addPackageItem(TUserPackage userPackage);

    boolean addPackageItems(Collection<TUserPackage> userPackages);
}
