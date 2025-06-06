package com.example.mytwitter.job;

import com.example.mytwitter.service.TweetsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestJob {

    private static final Logger LOG = LoggerFactory.getLogger(TestJob.class);
//
    @Resource
    private TweetsService tweetsService;
//    @Scheduled(fixedRate = 2000)
//    public void rateTimer() throws InterruptedException{
//        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
//        String dateFormattedString = formatter.format(new Date());
//        Thread.sleep(3000);
//        LOG.info("Rate Timer. current time: {}", dateFormattedString);
//    }
//
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void cronTimer() {
//        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
//        String dateFormattedString = formatter.format(new Date());
//
//        tweetsService.getPopularTweets();
//
//        LOG.info("Cron Timer. current time: {}", dateFormattedString);
//    }
}
