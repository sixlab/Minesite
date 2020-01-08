package cn.sixlab.minesite.config;

import cn.sixlab.minesite.utils.Err;
import cn.sixlab.minesite.utils.ResultUtils;
import cn.sixlab.minesite.utils.UserUtils;
import cn.sixlab.minesite.utils.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MineAuthFilter extends BasicAuthenticationFilter {
    public MineAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String token = UserUtils.readToken();

        String msg;
        if (StringUtils.isEmpty(token)) {
            msg = "login.token.empty";

            WebUtils.writeJson(ResultUtils.error(Err.AUTH, msg).toString());
        } else if (!UserUtils.verifyToken(token)) {
            msg = "login.token.verify.fail";

            WebUtils.writeJson(ResultUtils.error(Err.AUTH, msg).toString());
        } else {
            String username = UserUtils.getUsername();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
                    null, new ArrayList<>());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserUtils.writeToken(token);

            chain.doFilter(request, response);
        }
    }
}
