package cn.sixlab.minesite.service;

import cn.sixlab.minesite.dao.MsAuthDao;
import cn.sixlab.minesite.dao.MsRoleAuthDao;
import cn.sixlab.minesite.models.MsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private MsAuthDao authDao;

    @Autowired
    private MsRoleAuthDao roleAuthDao;

    public List<MsAuth> loadUserRole(Integer userId) {
        return authDao.findUserAuths(userId);
    }

    public MsAuth submitAuth(MsAuth auth) {
        if (null == auth.getId()) {
            auth.setStatus(1);
            auth.setCreateTime(new Date());
        }

        return authDao.save(auth);
    }

    public void delAuth(Integer authId) {
        Optional<MsAuth> byId = authDao.findById(authId);

        if (byId.isPresent()) {
            authDao.deleteById(authId);
            roleAuthDao.deleteAllByAuthCode(byId.get().getAuthCode());
        }

    }

    public void changeAuth(Integer authId) {
        Optional<MsAuth> byId = authDao.findById(authId);

        if (byId.isPresent()) {
            MsAuth msAuth = byId.get();
            if (0 == msAuth.getStatus()) {
                msAuth.setStatus(1);
            } else {
                msAuth.setStatus(0);
            }

            authDao.save(msAuth);
        }
    }
}
