package org.example.shardingJdbc.service;

import org.example.shardingJdbc.entity.TItem;

import java.util.Collection;

public interface ItemService {

    boolean addItem(TItem item);

    boolean addItems(Collection<TItem> items);
}
