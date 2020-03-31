package org.example.business.adaptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.business.entity.StorageEntity;
import org.example.business.mapper.StorageMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class StorageAdaptorImpl implements StorageAdaptor {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public int updateCommodityBalance(String commodityCode, int count) {
        return storageMapper.updateCommodityBalance(commodityCode, count);
    }

    @Override
    public Integer queryCommodityMoney(String commodityCode) {
        QueryWrapper<StorageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("money");
        queryWrapper.eq("commodity_code", commodityCode);
        queryWrapper.last("for update");
        StorageEntity entity = storageMapper.selectOne(queryWrapper);
        if (entity == null) return null;
        return entity.getMoney();
    }
}
