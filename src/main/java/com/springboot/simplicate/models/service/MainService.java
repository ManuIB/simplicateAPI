package com.springboot.simplicate.models.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface MainService {

	public void createReportFile(String fileName, String dtStr) throws IOException;

	public void sendReportByEmail(String fileName, String dtStr) throws MessagingException;
}
