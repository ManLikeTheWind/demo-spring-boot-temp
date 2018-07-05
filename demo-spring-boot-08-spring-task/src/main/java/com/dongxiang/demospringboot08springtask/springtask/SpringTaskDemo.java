package com.dongxiang.demospringboot08springtask.springtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * author:dongxiang
 * data:2018/7/5 9:53
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using: 
 * note: 
 * <p>@Scheduled 定时任务的核心</p>
 * spring-boot-starter-web 依赖即可，它包含了spring-context，定时任务相关的就属于这个JAR下的org.springframework.scheduling包中
 * <li>cron： cron表达式，根据表达式循环执行，与fixedRate属性不同的是它是将时间进行了切割。（@Scheduled(cron = "0/5 * * * * *")任务将在5、10、15、20...这种情况下进行工作）</li>
 * <li><b>fixedRate： 每隔多久执行一次，无视工作时间</b>（@Scheduled(fixedRate = 1000) 假设第一次工作时间为2018-05-29 16:58:28，工作时长为3秒，那么下次任务的时候就是2018-05-29 16:58:31）</li>
 * <li><b>fixedDelay： 当前任务执行完毕后等待多久继续下次任务</b>（@Scheduled(fixedDelay = 3000) 假设第一次任务工作时间为2018-05-29 16:54:33，工作时长为5秒，那么下次任务的时间就是2018-05-29 16:54:41）</li>
 * <li>b>initialDelay： 第一次执行延迟时间，只是做延迟的设定，与fixedDelay关系密切，配合使用，相辅相成。</b></li>
 * <p><b>cron表达式在线生成： http://www.pdtools.net/tools/becron.jsp</p>
 *
 * <p/>
 * <p><b>比较cron--fixedRate--fixedDelay</p>
 * <li><b>fixedRate： 每隔多久执行一次，无视工作时间，无论当前任务是否行完毕，当等待fixedRate后，都会执行下次任务</b></li>
 * <li><b>fixedDelay：每隔多久执行一次，但是必须当前任务执行完毕后，等待fixedDelay后，才继续下次任务</b></li>
 * <li><b>cron:与 fixedDelay相同，只是语法不同</b></li>
 *
 * <p/>
 * <p><b>@Async 代表该任务可以进行异步工作，由原本的串行改为并行</b></p>
 */
@Component
public class SpringTaskDemo {
     private static final Logger mLogger = LoggerFactory.getLogger(SpringTaskDemo.class);

     //TODO scheduled1 美妙执行这个方法体，具体结不结束，都会执行下一个；@Async--并行
     @Async
     @Scheduled(cron = "0/1 * * * * ?")
     /**<p><b>cron表达式在线生成： http://www.pdtools.net/tools/becron.jsp</p>*/
     public void scheduled1() throws InterruptedException {
         mLogger.info(Thread.currentThread()+" scheduled1 美妙执行一次：{} -pre ", LocalDateTime.now());
         Thread.sleep(3000);
         mLogger.info(Thread.currentThread()+" scheduled1 美妙执行一次：{} -aft ", LocalDateTime.now());
     }

// TODO -fixedRate-串行--有可能并行
     @Scheduled(fixedRate = 1000)
     public void scheduled2() throws InterruptedException {
         mLogger.info(Thread.currentThread()+" shceduled2 每秒执行一次：{} -pre ", LocalDateTime.now());
         Thread.sleep(500);
         mLogger.info(Thread.currentThread()+" shceduled2 每秒执行一次：{} -aft ", LocalDateTime.now());
     }

// TODO -fixedDelay-串行
     @Scheduled(fixedDelay = 3000)
     public void scheduled3() throws InterruptedException {
         mLogger.info(Thread.currentThread()+" scheduled3 上次执行完毕后 隔三秒继续执行：{} -pre ", LocalDateTime.now());
         Thread.sleep(5000);
         mLogger.info(Thread.currentThread()+" scheduled3 上次执行完毕后 隔三秒继续执行：{} -aft ", LocalDateTime.now());
     }

}
