package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsUserDao extends JpaRepository<MsUser, Integer> {

    MsUser findByUsername(String username);

}
