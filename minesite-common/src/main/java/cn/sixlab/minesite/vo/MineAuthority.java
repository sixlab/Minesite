package cn.sixlab.minesite.vo;

import cn.sixlab.minesite.models.MsRole;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class MineAuthority implements GrantedAuthority {
    private MsRole msRole;

    @Override
    public String getAuthority() {
        return msRole.getRoleName();
    }
}
