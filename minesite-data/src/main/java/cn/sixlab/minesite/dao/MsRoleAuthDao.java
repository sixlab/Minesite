package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsRoleAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsRoleAuthDao extends JpaRepository<MsRoleAuth, Integer> {

    void deleteAllByAuthCode(String authCode);

    void deleteAllByRoleId(Integer roleId);

}
