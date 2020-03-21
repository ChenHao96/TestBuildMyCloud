package org.example.business.service;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "${service.dubbo.version.storage}")
public class StorageServiceImpl implements StorageService {
    @Override
    public boolean deduct(String commodityCode, int count) {
        //TODO:
        return false;
    }
}
