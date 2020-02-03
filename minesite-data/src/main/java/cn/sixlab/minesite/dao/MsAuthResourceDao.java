package cn.sixlab.minesite.dao;

import cn.sixlab.minesite.models.MsAuthResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsAuthResourceDao extends JpaRepository<MsAuthResource, Integer> {

    void deleteAllByMenuCode(String menuCode);

    void deleteAllByRoleId(Integer roleId);

}
