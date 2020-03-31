package org.example.shardingJdbc.test;

import org.example.shardingJdbc.entity.TItem;
import org.example.shardingJdbc.entity.TUser;
import org.example.shardingJdbc.entity.TUserPackage;
import org.example.shardingJdbc.service.BusinessService;
import org.example.shardingJdbc.service.ItemService;
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
    private BusinessService businessService;

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

    @Test
    public void testBusinessService() {
        TUser user = new TUser();
        user.setUId(null);
        user.setStatus(true);
        user.setAccount("aabbcc1");
        user.setPassword("123456");
        user.setNickName("用户X");
        TUserPackage userPackage = new TUserPackage();
        userPackage.setItemId(1);
        userPackage.setItemCount(1);
        userPackage.setStatus(true);
        boolean realUpdate = businessService.addUserPackage(user, userPackage);
        Assert.isTrue(realUpdate, "添加用户和背包信息失败");
    }
}
