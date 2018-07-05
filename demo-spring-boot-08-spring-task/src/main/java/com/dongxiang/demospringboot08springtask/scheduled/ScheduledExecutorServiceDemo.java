package com.dongxiang.demospringboot08springtask.scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * author:dongxiang
 * data:2018/7/5 9:43
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * <p>基于ScheduledExecutorService 实现的，类似Timer</p>
 *  与Timer 类似，但效果更好：多线程并行处理定时任务时
 * <li>1.Timer 运行多个TimerTask时，只要其中有一个任务报错，异常没有捕获，其他任务会自动终止运行；ScheduledExecutorService不会</li>
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[]args){
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(10);

        // 参数：1、具体执行的任务   2、首次执行的延时时间
        //      3、任务执行间隔     4、间隔时间单位
        scheduledExecutorService.scheduleAtFixedRate(   ()-> System.out.println(Thread.currentThread()+" 执行任务A "+LocalDateTime.now() ),
                                            500,
                                                3000,
                                                        TimeUnit.MILLISECONDS);


    }

}
