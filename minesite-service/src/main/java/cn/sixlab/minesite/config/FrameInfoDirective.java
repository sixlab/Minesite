package cn.sixlab.minesite.config;


import cn.sixlab.minesite.models.MsMenu;
import cn.sixlab.minesite.service.MenuService;
import cn.sixlab.minesite.utils.UserUtils;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FrameInfoDirective implements TemplateDirectiveModel {

    @Autowired
    private MenuService service;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Integer userId = UserUtils.loginedUserId();
        String uri = MapUtils.getString(params, "uri", "/");

        MsMenu topMenu = service.loadTopMenu(userId, uri);

        List<MsMenu> navs = service.loadUserMenu(userId, 1);
        List<MsMenu> menus = new ArrayList<>();

        List messages = new ArrayList<>();

        env.setVariable("navs", new BeansWrapperBuilder(Configuration.VERSION_2_3_29).build().wrap(navs));
        env.setVariable("menus", new BeansWrapperBuilder(Configuration.VERSION_2_3_29).build().wrap(menus));

        env.setVariable("messages", new BeansWrapperBuilder(Configuration.VERSION_2_3_29).build().wrap(messages));

        if (body != null) {
            body.render(env.getOut());
        }
    }
}
