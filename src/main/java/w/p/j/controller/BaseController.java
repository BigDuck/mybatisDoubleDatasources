/*
 * Copyright (c) 2015 / 8 / 11 10 :43 :0
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 开发基类
 * @author nieweiren@sinovatech.com
 * @since 2012-10-15
 */

public class BaseController  {

	/** 获取资源文件信息 * */
	protected String getMessage(HttpServletRequest request, String key,Object... args) {
		return RequestContextUtils.getWebApplicationContext(request).getMessage(key, args, request.getLocale());
	}

	/**
	 * Model 中只需要转换一个对象成JSP
	 * 
	 * @return
	 */
	protected ModelAndView createJspView(String name) {
		ModelAndView mv = new ModelAndView(name);
		return mv;
	}

	/**
	 * 获取用户真实ip
	 * @param request
	 * @return
	 */
	protected String getRealIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) {
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}