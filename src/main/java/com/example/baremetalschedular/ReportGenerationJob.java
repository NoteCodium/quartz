package com.example.baremetalschedular;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerationJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // Retrieve parameters passed via JobDataMap
        JobDataMap dataMap = context.getMergedJobDataMap();
        String reportType = dataMap.getString("reportType");

        System.out.println("Executing Job: Generating " + reportType + " report at " + java.time.LocalDateTime.now());
    }
}