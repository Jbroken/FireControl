package com.fire.action.manage;

import com.fire.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jbroken on 2017/2/7.
 */
@Controller
public class UnitAction {
    @Autowired
    UnitService unitService;

    /**
     * 根据场所id删除场所
     * @param unitid
     * @return
     */
    @RequestMapping(value = "deleteUnit")
    public int deleteUnit(int unitid){
        return unitService.deleteUnitById(unitid);
    }
}
