package com.vooc.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class MailMess {
	public static void SendMail(String apiName) {
		String username = GetPropertiesFile.GetContentPropFile("EmailUsername");
		String password = ConvertType.DecodeBase64(GetPropertiesFile.GetContentPropFile("EmailPassword"));
		String recipient = GetPropertiesFile.GetContentPropFile("EmailTo");

		Properties props = new Properties();

		props.put("mail.smtp.host", GetPropertiesFile.GetContentPropFile("GmailSMTP"));
		props.put("mail.from", GetPropertiesFile.GetContentPropFile("GmailFrom"));
		props.put("mail.smtp.ssl.trust", GetPropertiesFile.GetContentPropFile("GmailSMTP"));
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", GetPropertiesFile.GetContentPropFile("GmailPort"));
//		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setRecipients(Message.RecipientType.TO, recipient);
			msg.setSubject("[VOOC][Umbalena][APi] The APi " + apiName + " have problem");
			msg.setSentDate(new Date());
			msg.setText("Dear users,\n \nApi " + apiName + " have issue. \n\nPlease check it!\n");

			Transport transport = session.getTransport("smtp");

			transport.connect(username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void SendSMS(String apiName) {
		String action = "create";
		String token = "d874d1787c7be90978923959063505d7";
		String[] phones = { "84917794211", "84389939755" };
		String title = null;
		String message = null;
		try {
			title = URLEncoder.encode("Demo API create campaign", "UTF-8");
			message = URLEncoder.encode("This Api " + apiName + " have problem. Please check it!", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String type = "cus";
		String couponGroup = "";
		String scheduleDate = "";
		String Brandname = "Umbalena.vn";

		String Quota = "20000";
		for (int i = 0; i < phones.length; i++) {
			HttpClient client = HttpClientBuilder.create().build();
			String requestUri = String.format(
					"https://crm.pavietnam.vn/api/sms/campaign?action=%s&token=%s&title=%s&type=%s&couponGroup=%s&scheduleDate=%s&brandName=%s&message=%s&phones=%s&Quota=%s",
					action, token, title, type, couponGroup, scheduleDate, Brandname, message, phones[i], Quota);
			System.out.println(requestUri);
			HttpGet request = new HttpGet(requestUri);
			try {
				client.execute(request);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
