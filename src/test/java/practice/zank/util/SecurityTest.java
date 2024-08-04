package practice.zank.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecurityTest {
    @Test
    void testPassword() {
        System.out.println(SecurityUtil.matches("123456","$2a$10$NF.PRbJy0C4XPIjxzxJ54ejT6z1qOfLxiUdcCXbB5ZO0BW6Zutoa6"));
    }
}
