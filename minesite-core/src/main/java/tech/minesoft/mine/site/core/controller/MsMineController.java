package tech.minesoft.mine.site.core.controller;

import tech.minesoft.mine.site.core.models.MsUser;
import tech.minesoft.mine.site.core.service.MsUserService;
import tech.minesoft.mine.site.core.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/i")
public class MsMineController {

    @Autowired
    private MsUserService userService;

    @Autowired
    private UserUtils userUtils;

    @RequestMapping(value = {"/", "/index"})
    public String index(ModelMap model) {
        MsUser msUser = userUtils.loginedUser();
        model.put("userInfo", msUser);
        return "i/user";
    }

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/{username}")
    public String test(ModelMap map, @PathVariable("username") String username) {
        MsUser user = userService.loadUser(username);
        map.put("userInfo", user);
        return "i/user";
    }

}