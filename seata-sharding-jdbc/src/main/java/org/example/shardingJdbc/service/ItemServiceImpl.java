package org.example.shardingJdbc.service;

import org.example.shardingJdbc.dao.TItemMapper;
import org.example.shardingJdbc.entity.TItem;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TItemMapper tItemMapper;

    @Override
    public boolean addItem(TItem item) {
        if (item == null) return false;
        return tItemMapper.insert(item) == 1;
    }

    @Override
    public boolean addItems(Collection<TItem> items) {
        if (CollectionUtils.isEmpty(items)) return false;
        final int expCount = items.size();
        int realCount = 0;
        for (TItem item : items) {
            if (item == null) continue;
            realCount += tItemMapper.insert(item);
        }
        return realCount == expCount;
    }
}
