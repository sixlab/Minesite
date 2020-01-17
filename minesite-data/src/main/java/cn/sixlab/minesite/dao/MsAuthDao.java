package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsAuth;
import cn.sixlab.minesite.models.MsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MsAuthDao extends JpaRepository<MsAuth, Integer> {

    @Query(" select u from MsAuth u,MsRoleAuth a,MsUserRole r " +
            " where u.authCode = a.authCode " +
            " and a.roleId = r.roleId " +
            " and r.userId = :userId ")
    List<MsRole> findUserAuths(@Param("userId") Integer userId);
}
