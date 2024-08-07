package org.springframework.test.ioc;


import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceAndResourceLoaderTest {

    @Test
    public void testResourceLoader() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        Assertions.assertEquals(content,"hello world");

        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        Assertions.assertEquals(content,"hello world");

        resource = resourceLoader.getResource("https://www.baidu.com");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
