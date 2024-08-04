package practice.zank.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import practice.zank.entity.User;

@SpringBootTest
public class JwtUtilTest {
    @Test
    void testJwtGeneration() {

    }
    @Test
    void testJwtMethod() {
        User user = new User();
        user.setUsername("zank");
        user.setPassword("123456");
        System.out.println(JwtUtil.generateToken(user));
    }
    @Test
    void testParseJwt() {
        User user = JwtUtil.parseToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7InBhc3N3b3JkIjoiJDJhJDEwJE5GLlBSYkp5MEM0WFBJanh6eEo1NGVqVDZ6MXFPZkx4aVVkY0NYYk" +
                "I1Wk8wQlc2WnV0b2E2IiwidXNlcm5hbWUiOiIzMjk4MjMyMDIxIn0sImV4cCI6MTcyMzM1NjQzOH0." +
                "btoGM6L6CFKGo1QaS3vznYpwh9e5LcPnKTT_7tRG8P0");
        System.out.println(user);
    }
}
