package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsRoleMenuDao extends JpaRepository<MsRoleMenu, Integer> {

    void deleteAllByMenuCode(String menuCode);

    void deleteAllByRoleId(Integer roleId);

}
