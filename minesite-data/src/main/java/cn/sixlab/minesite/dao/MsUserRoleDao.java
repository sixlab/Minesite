package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsUserRoleDao extends JpaRepository<MsUserRole, Integer> {

    void deleteAllByRoleId(Integer roleId);
}
