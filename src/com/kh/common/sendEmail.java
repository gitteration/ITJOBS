package com.kh.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail  {

		// 비밀번호 찾을 시 임시 이메일 발송
	
		public static void sendPwd(String email, String userPwd){

				
				Properties props = System.getProperties();
				props.put("mail.smtp.host", "smtp.naver.com");
				props.put("mail.smtp.port", "25");
				props.put("defaultEncoding", "utf-8");
				props.put("mail.smtp.auth", "true");

				final String userId = "show10033";
				final String userPw = "@show759153";

				try {
				String sender = "show10033@naver.com"; //보내는사람 메일주소. ex) mailSender@naver.com
				String subject = "ITJobs 유저님의 임시 비밀번호 입니다."; //메일 제목
				String body = userPwd ; //메일 본문

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				String un=userId;
				String pw=userPw;

				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
					}
				});
				session.setDebug(false); //Debug 모드 설정.

				Message mimeMessage = new MimeMessage(session);
				mimeMessage.setFrom(new InternetAddress(sender)); 

				// 받는 사람 이메일주소 세팅
				InternetAddress[] toAddr = new InternetAddress[1];
				toAddr[0] = new InternetAddress (email); // 보낼 사람의 이메일
				

				mimeMessage.setRecipients(Message.RecipientType.TO, toAddr ); //수신자 셋팅

				mimeMessage.setSubject(subject); //제목 세팅
				mimeMessage.setText(body); //본문 세팅

				//메일 발송
				Transport.send(mimeMessage);
				
				System.out.println("메일 발송 성공!!");
				} catch (Exception e) {
				System.out.println("메일보내기 오류 : "+ e.getMessage());
				}

				

				}
			
		// 회원가입시 인증번호 발송
		
		public static void cerNo(String email, String cerNo){

			Properties props = System.getProperties();
			props.put("mail.smtp.host", "smtp.naver.com");
			props.put("mail.smtp.port", "25");
			props.put("defaultEncoding", "utf-8");
			props.put("mail.smtp.auth", "true");

			final String userId = "show10033";
			final String userPw = "***********";

			try {
			String sender = "show10033@naver.com"; //보내는사람 메일주소. ex) mailSender@naver.com
			String subject = "ITJobs 유저님의 인증번호 입니다."; //메일 제목
			String body = "인증번호 받아라 "+ cerNo ; //메일 본문

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=userId;
			String pw=userPw;

			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(un, pw);
				}
			});
			session.setDebug(false); //Debug 모드 설정.

			Message mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(sender)); 

			// 받는 사람 이메일주소 세팅
			InternetAddress[] toAddr = new InternetAddress[1];
			toAddr[0] = new InternetAddress (email);
			

			mimeMessage.setRecipients(Message.RecipientType.TO, toAddr ); //수신자 셋팅

			mimeMessage.setSubject(subject); //제목 세팅
			mimeMessage.setText(body); //본문 세팅

			//메일 발송
			Transport.send(mimeMessage);
			
			System.out.println("메일 발송 성공!!");
			} catch (Exception e) {
			System.out.println("메일보내기 오류 : "+ e.getMessage());
			}

			

			}




}
		
		
