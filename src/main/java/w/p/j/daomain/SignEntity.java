/*
 * Copyright (c) 2015 / 8 / 11 10 :47 :56
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.daomain;

import java.util.Date;


public class SignEntity  {
	private static final long serialVersionUID = -5817119588334551147L;
	private Date signTime;	// 签到时间
	private String signIp;	// 签到IP
	private String signer; // 签到人
	private String signTag;// 签到月份 2011、2012、2013
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public String getSignIp() {
		return signIp;
	}
	public void setSignIp(String signIp) {
		this.signIp = signIp;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	public String getSignTag() {
		return signTag;
	}
	public void setSignTag(String signTag) {
		this.signTag = signTag;
	}
	
}
