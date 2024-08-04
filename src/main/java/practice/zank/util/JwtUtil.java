package practice.zank.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import practice.zank.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET = "zank";
    private static final Long EXPIRE = 1000L * 60 * 60 * 24 * 7;

    public static <T extends User> String generateToken(T user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        return JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static User parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getClaim("user")
                .as(User.class);
    }
}
