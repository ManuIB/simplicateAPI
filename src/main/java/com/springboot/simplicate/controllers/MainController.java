package com.springboot.simplicate.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.simplicate.models.service.MainService;

@RestController
public class MainController {

	@Autowired
	private MainService mainService;

	// Launch every Monday
	@Scheduled(cron = "0 0 8 * * *")
	public void scheduledTasks() throws IOException, MessagingException {

		Date date = new Date();
		// Create a pattern
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		// Format date to string
		String dtStr = formatter.format(date);
		String fileName = dtStr + "_report.xlsx";
		// Format date to string - to show in the report and email
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		dtStr = formatter.format(date);

		mainService.createReportFile(fileName, dtStr);
		mainService.sendReportByEmail(fileName, dtStr);
	}
}
