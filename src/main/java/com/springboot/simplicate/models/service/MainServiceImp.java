package com.springboot.simplicate.models.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springboot.simplicate.AppConfig;
import com.springboot.simplicate.models.Datum;
import com.springboot.simplicate.models.Item;

@Service
public class MainServiceImp implements MainService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private LeaveServiceImpl leaveServiceImpl;

	@Autowired
	private AppConfig appConfig;

	@Override
	public void createReportFile(String fileName, String dtStr) throws IOException {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Report");

		int rowNum = 0;

		// Style for header
		CellStyle theaderStyle = getCellStyle(workbook, "header");
		CellStyle theaderLeftStyle = getCellStyle(workbook, "headerLeft");
		// Style for info
		CellStyle tinfoStyle = getCellStyle(workbook, "info");
		// Style for Body
		CellStyle tbodyStyle = getCellStyle(workbook, "body");
		CellStyle tbodyLeftStyle = getCellStyle(workbook, "bodyLeft");

		// Report info
		Row info = sheet.createRow(rowNum++);
		info.createCell(0).setCellValue("Leave Report");
		info.getCell(0).setCellStyle(tinfoStyle);
		info = sheet.createRow(rowNum++);
		info.createCell(0).setCellValue("Date: " + dtStr);
		info.getCell(0).setCellStyle(tinfoStyle);
		info = sheet.createRow(rowNum++);
		info.createCell(0).setCellValue("");

		// Header
		Row header = sheet.createRow(rowNum++);
		header.createCell(0).setCellValue("Name");
		header.createCell(1).setCellValue("Year");
		header.createCell(2).setCellValue("Begin");
		header.createCell(3).setCellValue("Eind");
		header.createCell(4).setCellValue("Uren");
		header.createCell(5).setCellValue("Dagen");
		header.createCell(6).setCellValue("Verlofsoort");
		header.createCell(7).setCellValue("Reden");

		header.getCell(0).setCellStyle(theaderLeftStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		header.getCell(4).setCellStyle(theaderStyle);
		header.getCell(5).setCellStyle(theaderStyle);
		header.getCell(6).setCellStyle(theaderStyle);
		header.getCell(7).setCellStyle(theaderStyle);

		// All employee ids
		List<String> employees = employeeServiceImpl.findAllIds();

		for (String employee : employees) {

			Item leaveReport = leaveServiceImpl.findLeavePerEmployee(employee);

			// Body
			for (Datum datum : leaveReport.getData()) {
				Row row = sheet.createRow(rowNum++);
				int position = 0;

				// Name
				Cell cell = row.createCell(position++);
				cell.setCellValue(datum.getEmployee().getName());
				cell.setCellStyle(tbodyLeftStyle);

				// Year
				cell = row.createCell(position++);
				cell.setCellValue(datum.getYear());
				cell.setCellStyle(tbodyStyle);

				// Begin
				cell = row.createCell(position++);
				cell.setCellValue(datum.getStartDate());
				cell.setCellStyle(tbodyStyle);

				// Eind
				cell = row.createCell(position++);
				cell.setCellValue(datum.getEnd_date());
				cell.setCellStyle(tbodyStyle);

				// Uren
				cell = row.createCell(position++);
				cell.setCellValue(datum.getHours());
				cell.setCellStyle(tbodyStyle);

				// Dagen
				cell = row.createCell(position++);
				cell.setCellValue(datum.getHours() / 8);
				cell.setCellStyle(tbodyStyle);

				// Verlofsoort
				cell = row.createCell(position++);
				cell.setCellValue(datum.getLeavetype().getLabel());
				cell.setCellStyle(tbodyStyle);

				// Reden
				cell = row.createCell(position++);
				cell.setCellValue(datum.getDescription());
				cell.setCellStyle(tbodyStyle);
			}
		}

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);

		File currDir = new File("src/main/resources/static/reports/");
//		String path = currDir.getAbsolutePath();
		String fileLocation = currDir.getAbsolutePath() + "/" + fileName;

		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
	}

	@Override
	public void sendReportByEmail(String fileName, String dtStr) throws MessagingException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(appConfig.getEmailTo());
		helper.setSubject("[" + dtStr + "] Leave days report");
		// true = text/html
		helper.setText(
				"<p>Hi,<br /><br />this is an automatic email with the attached report.<br /><br /><br />Thanks!</p>",
				true);

		// hard coded a file path
		FileSystemResource file = new FileSystemResource(new File("./src/main/resources/static/reports/" + fileName));
		helper.addAttachment(fileName, file);

		javaMailSender.send(msg);
	}

	private CellStyle getCellStyle(Workbook workbook, String type) {

		// Font style
		Font titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 12);
		titleFont.setBold(true);

		CellStyle style = workbook.createCellStyle();

		if (type.equals("header")) {
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			style.setFillForegroundColor(IndexedColors.ROSE.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setFont(titleFont);
		} else if (type.equals("headerLeft")) {
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			style.setFillForegroundColor(IndexedColors.ROSE.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setAlignment(HorizontalAlignment.LEFT);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setFont(titleFont);
		} else if (type.equals("info")) {
			style.setAlignment(HorizontalAlignment.LEFT);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setFont(titleFont);
		} else if (type.equals("body")) {
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
		} else if (type.equals("bodyLeft")) {
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setAlignment(HorizontalAlignment.LEFT);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
		}

		return style;
	}
}
