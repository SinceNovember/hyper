package com.simple.hyper.system.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 上传文件到阿里云OSS配置
 *
 * @author SinceNovember
 * @date 2022/12/27
 */
@Data
@Configuration
@EnableConfigurationProperties({OSSClientProperties.class})
public class OSSClientConfig {

    @Bean
    public OSSClient createOssClient(OSSClientProperties clientProperties) {
        return (OSSClient) new OSSClientBuilder().build(
                clientProperties.getEndpoint(),
                clientProperties.getAccessKeyId(),
                clientProperties.getAccessKeySecret());
    }
}
