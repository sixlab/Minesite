package cn.sixlab.minesite.controller;

import cn.sixlab.minesite.models.MsMenu;
import cn.sixlab.minesite.service.MenuService;
import cn.sixlab.minesite.utils.ResultUtils;
import cn.sixlab.minesite.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/userMenu")
    public Result userMenu() {
        Page<MsMenu> msMenus = menuService.loadUserMenu(null, 1);

        return ResultUtils.success(msMenus);
    }
}
