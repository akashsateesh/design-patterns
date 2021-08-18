package designPatterns.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class Application {
    
    public static void main(String[] args) throws SchedulerException {
    
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        
        scheduler.start();
        
         JobDetail job = newJob(HelloWorldJob.class)
                .withIdentity("job1", "group1")
                .build();
    
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(4)
                        .repeatForever())
                .build();
        
        scheduler.scheduleJob(job,trigger);
        
    }
}
