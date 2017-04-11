package com.fire.action.manage;

import com.fire.po.FiretableInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by BZhao on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class CheckActionTest {
    @Autowired
    CheckAction checkAction;

    @Test
    public void getTableInfo() throws Exception {
        List<FiretableInformation> ls =  checkAction.getTableInfo("2017-04-06","20170406155234");
        System.out.println(ls);
    }

}