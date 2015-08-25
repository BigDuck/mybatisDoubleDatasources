/*
 * Copyright (c) 2015 / 8 / 11 10 :40 :45
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import w.p.j.daomain.SignEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/sign")
public class SignController  {

	
	@RequestMapping("/doSign")
	@ResponseBody
	public String doSign(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 先查询是否已经签到
			boolean ifHasSigned =false;
			// signService.ifHasSigned();
			if(ifHasSigned) {
				return "['result':'1']";
			} else {

				SignEntity signEntity = new SignEntity();
				Date signDate = new Date();
				signEntity.setSignTime(signDate);
				Calendar cal = Calendar.getInstance();
			    int day = cal.get(Calendar.DATE);
			    int month = cal.get(Calendar.MONTH) + 1;
			    int year = cal.get(Calendar.YEAR);
				signEntity.setSignTag(year + "" + month + "" + day);
				signEntity.setSigner("zhoukun");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "['result':'0']";

	}
	@RequestMapping("/getSignList")
	public String getSignList(HttpServletRequest request, HttpServletResponse response) {
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		return null;
	}
	
}
