package com.example.baremetalschedular;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail reportJobDetail() {
        return JobBuilder.newJob(ReportGenerationJob.class)
                .withIdentity("reportJob", "reportsGroup")
                .usingJobData("reportType", "DAILY_SALES") // Passing data
                .storeDurably() // Keep job definition even if no trigger points to it
                .build();
    }

    @Bean
    public Trigger reportJobTrigger(JobDetail reportJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(reportJobDetail)
                .withIdentity("reportTrigger", "reportsGroup")
                // Runs every 10 seconds for testing (or use CronScheduleBuilder.cronSchedule("0 0/5 * * * ?"))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();
    }
}

