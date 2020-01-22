package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MsMenuDao extends JpaRepository<MsMenu, Integer> {

    @Query(" select m from MsMenu m,MsRoleMenu rm " +
            " where m.menuCode = rm.menuCode " +
            " and rm.roleId = :roleId ")
    List<MsMenu> findRoleMenus(@Param("roleId") Integer roleId);

    @Query(" select m from MsMenu m,MsRoleMenu rm " +
            " where m.menuCode = rm.menuCode " +
            " and m.status = 1 " +
            " and rm.roleId = :roleId ")
    List<MsMenu> findActiveRoleMenus(@Param("roleId") Integer roleId);

}
