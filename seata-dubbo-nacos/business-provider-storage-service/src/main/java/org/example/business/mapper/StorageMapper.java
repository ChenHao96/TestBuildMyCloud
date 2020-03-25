package org.example.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;
import org.example.business.entity.StorageEntity;

public interface StorageMapper extends BaseMapper<StorageEntity> {

    @Update("update storage_tbl set count = count - #{param2,jdbcType=INTEGER} " +
            "where commodity_code = #{param1,jdbcType=VARCHAR} and count >= #{param2,jdbcType=INTEGER}")
    int updateCommodityBalance(String commodityCode, int count);
}
