package org.example.shardingJdbc.test;

import org.example.shardingJdbc.entity.TItem;
import org.example.shardingJdbc.entity.TUser;
import org.example.shardingJdbc.service.ItemService;
import org.example.shardingJdbc.service.UserPackageService;
import org.example.shardingJdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPackageService userPackageService;

    @Autowired
    private ItemService itemServer;

    @Test
    public void testUserAdd() {
        TUser record = new TUser();
        for (int i = 0; i < 10; i++) {
            record.setUId(null);
            record.setStatus(true);
            record.setAccount("b" + i);
            record.setPassword("123456");
            record.setNickName("用户" + i);
            boolean realUpdate = userService.addUserRecord(record);
            Assert.isTrue(realUpdate, "新增用户失败!");
        }
    }

    @Test
    public void testAddItem() {
        TItem item = new TItem();
        item.setItemName("物品2");
        item.setStatus(true);
        boolean realUpdate = itemServer.addItem(item);
        Assert.isTrue(realUpdate, "添加条目失败");
    }
}
