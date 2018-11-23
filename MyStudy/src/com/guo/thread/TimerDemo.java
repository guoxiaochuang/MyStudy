package com.guo.thread;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName: TimerDemo.java
 * @Description: 定时器举例
 * @author: gxc
 * @date: 2018年11月5日上午9:58:19
 */
public class TimerDemo {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务执行了....");
			}
		}, format.parse("2018-11-05 10:00:00"));
	}
}
