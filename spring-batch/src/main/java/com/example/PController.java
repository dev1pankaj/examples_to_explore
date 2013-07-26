package com.example;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/batch")
public class PController implements ApplicationContextAware{
		Logger logger=Logger.getLogger(PController.class.getName());
		private ApplicationContext applicationContext;
		@RequestMapping
		public void launchJob(){
				// launch the job
				JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
				Job job = (Job) applicationContext.getBean("userIns");
				try {
					jobLauncher.run(job, new JobParametersBuilder().addDate("start", new Date()).toJobParameters());
				} catch (JobExecutionAlreadyRunningException e) {
					logger.log(Level.SEVERE, e.getMessage());
				} catch (JobRestartException e) {
					logger.log(Level.SEVERE, e.getMessage());
				} catch (JobInstanceAlreadyCompleteException e) {
					logger.log(Level.SEVERE, e.getMessage());
				} catch (JobParametersInvalidException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
		}

		@Override
		public void setApplicationContext(ApplicationContext applicationContext)
				throws BeansException {
			// TODO Auto-generated method stub
			this.applicationContext=applicationContext;
			
		}
}
