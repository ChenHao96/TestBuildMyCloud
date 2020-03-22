package org.example.business.adaptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.business.entity.StorageEntity;
import org.example.business.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StorageAdaptorImpl implements StorageAdaptor {

    @Autowired
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
        StorageEntity entity = storageMapper.selectOne(queryWrapper);
        if (entity == null) return null;
        return entity.getMoney();
    }
}
