package cn.sixlab.minesite.service;

import cn.sixlab.minesite.dao.MsUserDao;
import cn.sixlab.minesite.models.MsUser;
import cn.sixlab.minesite.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private MsUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MsUser msUser = userDao.findByUsername(username);

        if (null == msUser) {
            throw new UsernameNotFoundException("login.not.exist");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setMsUser(msUser);
        return loginUser;
    }
}
