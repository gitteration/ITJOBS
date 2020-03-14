package com.kh.common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String key) {
		String value="";
		if(key!=null && (key.equals("pw") || key.equals("newPw"))) {
			String userPwd=super.getParameter(key);
			try {
				MessageDigest md=MessageDigest.getInstance("SHA-512");
				byte[] bytes=userPwd.getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				value=Base64.getEncoder().encodeToString(md.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			//value=;
		}else {
			value=super.getParameter(key);
		}
		
		return value;
	}
}
