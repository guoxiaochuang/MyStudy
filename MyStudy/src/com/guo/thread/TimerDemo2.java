package com.guo.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo2 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("hello");
			}
		}, new Date(), 500);
	}

}
