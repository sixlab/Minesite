package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MsMenuDao extends JpaRepository<MsMenu, Integer> {

    @Query(" select m from MsUserRole ur,MsRoleAuth ra,MsAuthResource ar, MsMenu m" +
            " where ur.userId = :userId " +
            " and ur.roleId = ra.roleId " +
            " and ra.authId = ar.authId " +
            " and ar.type = 'menu' " +
            " and ar.resourceId = m.id ")
    List<MsMenu> findUserMenus(@Param("userId") Integer userId);

    @Query(" select m from MsRoleAuth ra,MsAuthResource ar, MsMenu m" +
            " where ra.roleId = :roleId " +
            " and ra.authId = ar.authId " +
            " and ar.type = 'menu' " +
            " and ar.resourceId = m.id " +
            " and m.status = 1 ")
    List<MsMenu> findRoleMenus(@Param("roleId") Integer roleId);

    @Query(" select m from MsUserRole ur,MsRoleAuth ra,MsAuthResource ar, MsMenu m" +
            " where ur.userId = :userId " +
            " and ur.roleId = ra.roleId " +
            " and ra.authId = ar.authId " +
            " and ar.type = 'menu' " +
            " and ar.resourceId = m.id " +
            " and m.status = 1 ")
    List<MsMenu> findActiveUserMenus(@Param("userId") Integer userId);

    @Query(" select m from MsRoleAuth ra,MsAuthResource ar, MsMenu m" +
            " where ra.roleId = :roleId " +
            " and ra.authId = ar.authId " +
            " and ar.type = 'menu' " +
            " and ar.resourceId = m.id ")
    List<MsMenu> findActiveRoleMenus(@Param("roleId") Integer roleId);

}
