package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MsUserDao extends JpaRepository<MsUser, Integer> {

    MsUser findByUsername(String username);

    @Query(" select count(u.id) from MsUserRole u,MsRoleAuth a " +
            " where u.roleId = a.roleId " +
            " and u.userId = :userId " +
            " and a.authCode in :codes ")
    int countUserRole(@Param("userId") Integer userId, @Param("codes") String[] codes);
}
