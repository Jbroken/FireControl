package com.fire.action.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by BZhao on 2017/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class PoliceManageActionTest {
    @Resource(name = "policeManageAction")
    PoliceManageAction policeManageAction;

    @Test
    public void userlogin() throws Exception {
        policeManageAction.userLogin("79833","123456");

    }

}