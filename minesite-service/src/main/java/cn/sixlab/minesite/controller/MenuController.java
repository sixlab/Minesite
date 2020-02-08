package cn.sixlab.minesite.controller;

import cn.sixlab.minesite.models.MsMenu;
import cn.sixlab.minesite.service.MenuService;
import cn.sixlab.minesite.utils.ResultUtils;
import cn.sixlab.minesite.utils.UserUtils;
import cn.sixlab.minesite.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PreAuthorize("hasPermission('menu', 'denyAll')")
    @ResponseBody
    @RequestMapping("/userMenu")
    public Result userMenu() {
        Integer userId = UserUtils.loginedUserId();
        List<MsMenu> menus = menuService.loadUserMenu(userId, 1);
        return ResultUtils.success(menus);
    }

}
