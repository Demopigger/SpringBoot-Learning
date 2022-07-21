package com.didispace.chapter15;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PropertiesTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StringEncryptor stringEncryptor;

    @Value("${datasource.password:}")
    private String password;

    @Test
    public void test() {
        log.info("datasource.password : {}", password);
    }

    @Test
    public void jasyptTest() {
        // 加密
        System.out.println(stringEncryptor.encrypt("root"));    // JSrINYe4IBotHndGjX1hnmY3mtPNUJlXjP12cx1+pHqUz2FNXGPu3Frnajh3QCXg
        // 解密
        System.out.println(stringEncryptor.decrypt("1zWzvCYOGpvC8Ek80qjm3VPkTgmB3s+hlzfOK08LL22RgPhozrtr+hSqqc7pBwrv"));    // root
    }


}
