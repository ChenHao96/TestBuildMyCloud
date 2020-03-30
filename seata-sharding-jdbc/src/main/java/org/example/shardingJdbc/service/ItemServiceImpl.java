package org.example.shardingJdbc.service;

import org.example.shardingJdbc.dao.TItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TItemMapper tItemMapper;
}
