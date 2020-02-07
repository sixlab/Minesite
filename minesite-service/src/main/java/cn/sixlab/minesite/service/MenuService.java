package cn.sixlab.minesite.service;

import cn.sixlab.minesite.dao.MsMenuDao;
import cn.sixlab.minesite.dao.MsAuthResourceDao;
import cn.sixlab.minesite.models.MsMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MsMenuDao menuDao;

    @Autowired
    private MsAuthResourceDao roleMenuDao;

    public List<MsMenu> loadUserMenu(Integer userId) {
        return menuDao.findUserMenus(userId);
    }

    public MsMenu submitMenu(MsMenu menu) {
        if (null == menu.getId()) {
            menu.setStatus(1);
            menu.setCreateTime(new Date());
        }

        return menuDao.save(menu);
    }

    public void delMenu(Integer menuId) {
        Optional<MsMenu> byId = menuDao.findById(menuId);

        if (byId.isPresent()) {
            menuDao.deleteById(menuId);
            roleMenuDao.deleteAllByResourceIdAndType(byId.get().getId(), "menu");
        }

    }

    public void changeMenu(Integer menuId) {
        Optional<MsMenu> byId = menuDao.findById(menuId);

        if (byId.isPresent()) {
            MsMenu MsMenu = byId.get();
            if (0 == MsMenu.getStatus()) {
                MsMenu.setStatus(1);
            } else {
                MsMenu.setStatus(0);
            }

            menuDao.save(MsMenu);
        }
    }
}
