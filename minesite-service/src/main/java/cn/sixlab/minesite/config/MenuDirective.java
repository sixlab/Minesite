package cn.sixlab.minesite.config;


import cn.sixlab.minesite.service.MenuService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MenuDirective implements TemplateDirectiveModel {

    @Autowired
    private MenuService service;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        //
        // String uri = MapUtils.getString(params, "uri", "/");
        //
        // List<Menu> navs = service.menus(1);
        // List<Menu> menus = service.menus(2, uri);
        //
        // env.setVariable("navs", new BeansWrapperBuilder(Configuration.VERSION_2_3_29).build().wrap(navs));
        // env.setVariable("menus", new BeansWrapperBuilder(Configuration.VERSION_2_3_29).build().wrap(menus));
        //
        // if (body != null) {
        //     body.render(env.getOut());
        // }
    }
}
