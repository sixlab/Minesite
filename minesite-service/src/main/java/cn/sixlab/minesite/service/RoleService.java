package cn.sixlab.minesite.service;

import cn.sixlab.minesite.dao.MsRoleDao;
import cn.sixlab.minesite.dao.MsUserDao;
import cn.sixlab.minesite.models.MsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private MsRoleDao roleDao;

    public List<MsRole> loadUserRole(Integer userId) {
        return roleDao.findUserRoles(userId);
    }
}
