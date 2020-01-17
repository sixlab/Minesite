package cn.sixlab.minesite.service;

import cn.sixlab.minesite.dao.MsAuthDao;
import cn.sixlab.minesite.dao.MsRoleDao;
import cn.sixlab.minesite.models.MsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private MsAuthDao authDao;

    public List<MsRole> loadUserRole(Integer userId) {
        return authDao.findUserAuths(userId);
    }
}
