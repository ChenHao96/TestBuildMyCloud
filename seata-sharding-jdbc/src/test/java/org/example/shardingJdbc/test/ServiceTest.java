package org.example.shardingJdbc.test;

import org.example.shardingJdbc.entity.TUser;
import org.example.shardingJdbc.service.ItemService;
import org.example.shardingJdbc.service.UserPackageService;
import org.example.shardingJdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
            record.setAccount("a"+i);
            record.setPassword("123456");
            record.setNickName("用户" + i);
            userService.addUserRecord(record);
        }
    }
}
