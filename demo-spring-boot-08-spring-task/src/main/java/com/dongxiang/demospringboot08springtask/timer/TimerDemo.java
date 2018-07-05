package com.dongxiang.demospringboot08springtask.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * author:dongxiang
 * data:2018/7/5 9:33
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note: <li>基于Timer 实现的定时调度，基本就是手撸代码，目前应用较少，不是很推荐</li>
 */
public class TimerDemo {
   
  public static void main(String[]args){
      TimerTask timerTask=new TimerTask() {
          @Override
          public void run() {
              System.out.println(TimerDemo.class.getSimpleName()+" 执行任务 - "+LocalDateTime.now());
          }
      };
      Timer timer=new Timer();
      timer.schedule(timerTask, 500,3000);
  }



}
