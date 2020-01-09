package cn.sixlab.minesite.utils;

import cn.sixlab.minesite.models.MsUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class UserUtils {
    private static String TOKEN_KEY = "MS_USER";

    public static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            String name = authentication.getName();
            if (!StringUtils.equalsIgnoreCase(name, "anonymousUser")) {
                return name;
            }
        }
        return null;
    }

    public static boolean isLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null != auth) {
            return !(auth instanceof AnonymousAuthenticationToken);
        }
        return false;
    }

    public static void logout() {
        WebUtils.addCookie(TOKEN_KEY, "", 1);
        SecurityContextHolder.clearContext();
    }

    public static String login(MsUser msUser) {
        String token = createToken(msUser.getUsername());

        writeToken(token);

        return token;
    }

    private static String createToken(String username) {
        Date expiration = new Date(System.currentTimeMillis() + expire() * 1000 + 60000);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, signKey())
                .compact();
    }

    public static void writeToken(String token) {
        WebUtils.addCookie(TOKEN_KEY, token, expire());
    }

    public static String readToken() {
        HttpServletRequest request = WebUtils.getRequest();

        // 先读取 request 防 cookie 缓存
        String token = request.getParameter(TOKEN_KEY);

        // 如果没有，读取 cookie
        if (StringUtils.isEmpty(token)) {
            token = WebUtils.getCookie(TOKEN_KEY);
        } else {
            // 防止 cookie 缓存其他 uuid
            WebUtils.addCookie(TOKEN_KEY, token, expire());
        }

        return token;
    }

    public static boolean verifyToken(String token) {
        String subject;
        try {
            subject = Jwts.parser()
                    .setSigningKey(signKey())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            subject = null;
        }
        return StringUtils.isNotEmpty(subject);
    }

    private static int expire() {
        return Integer.valueOf(Ctx.getProperty("minesite.login.seconds"));
    }

    private static String signKey() {
        return Ctx.getProperty("minesite.login.sign");
    }
}
