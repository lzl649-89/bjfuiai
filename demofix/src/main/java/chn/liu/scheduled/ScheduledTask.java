package chn.liu.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	@Scheduled(fixedDelayString="${jobs.fixedDelay}")
	public void task_1() {
		System.out.println("task_1 now + " + new Date());
	}
	
	@Scheduled(cron="${jobs.cron}")
	public void task_2() {
		System.out.println("task_2 now + " + new Date());
	}
}
