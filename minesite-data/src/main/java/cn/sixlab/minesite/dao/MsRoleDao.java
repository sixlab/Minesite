package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MsRoleDao extends JpaRepository<MsRole, Integer> {

    @Query(" select u from MsRole u,MsUserRole a " +
            " where u.id = a.roleId " +
            " and u.userId = :userId ")
    List<MsRole> findUserRoles(@Param("username") Integer userId);

}
