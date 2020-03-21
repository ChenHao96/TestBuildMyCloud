package org.example.business;

public interface StorageService {

    /**
     * 服务提供者填写的应用名称 方便消费者订阅服务
     */
    String DUBBO_SERVICE_APPLICATION_NAME = "dubbo-service-application-storageService";

    /**
     * 扣除存储数量
     */
    boolean deduct(String commodityCode, int count);
}
