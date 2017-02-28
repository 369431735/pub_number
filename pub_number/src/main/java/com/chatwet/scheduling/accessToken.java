package com.chatwet.scheduling;

import com.weChatHttp.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by lixing on 2017/2/14.
 */
@Configuration
@EnableScheduling // 启用定时任务
public class accessToken {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron="0 0 0/2 * * ?") //每2小时执行一次
    public void statusCheck() {
        AccessToken.findAccessTokenByWeb();
    }
}
