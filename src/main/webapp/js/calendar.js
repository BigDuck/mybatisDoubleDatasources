var calUtil = {
	getDaysInmonth : function(iMonth, iYear) {
		var dPrevDate = new Date(iYear, iMonth, 0);
		return dPrevDate.getDate();
	},
	bulidCal : function(iYear, iMonth) {
		var aMonth = new Array();
		aMonth[0] = new Array(7);
		aMonth[1] = new Array(7);
		aMonth[2] = new Array(7);
		aMonth[3] = new Array(7);
		aMonth[4] = new Array(7);
		aMonth[5] = new Array(7);
		aMonth[6] = new Array(7);
		var dCalDate = new Date(iYear, iMonth - 1, 1);
		var iDayOfFirst = dCalDate.getDay();
		var iDaysInMonth = calUtil.getDaysInmonth(iMonth, iYear);
		var iVarDate = 1;
		var d, w;
		aMonth[0][0] = "日";
		aMonth[0][1] = "一";
		aMonth[0][2] = "二";
		aMonth[0][3] = "三";
		aMonth[0][4] = "四";
		aMonth[0][5] = "五";
		aMonth[0][6] = "六";
		for (d = iDayOfFirst; d < 7; d++) {
			aMonth[1][d] = iVarDate;
			iVarDate++;
		}
		for (w = 2; w < 7; w++) {
			for (d = 0; d < 7; d++) {
				if (iVarDate <= iDaysInMonth) {
					aMonth[w][d] = iVarDate;
					iVarDate++;
				}
			}
		}
		return aMonth;
	},
	ifHasSigned : function(signList, iYear , iMonth , day) {
		var signed = false;
		$.each(signList, function(index, item) {
			if (item.signTag == iYear + "" + iMonth + "" + day) {
				signed = true;
				return false;
			}
		});
		return signed;
	},
	drawCal : function(iYear, iMonth, signList) {
		var myMonth = calUtil.bulidCal(iYear, iMonth);
		var htmls = new Array();
		htmls.push("<div class='sign_main'>");
		htmls.push("<div class='sign_succ_calendar_title'>");
		htmls.push("<div class='calendar_month_next' onclick = 'calUtil.drawOtherMonth(" + iYear + "," + iMonth + " , \"next\")';>&nbsp;</div>");
		htmls.push("<div class='calendar_month_prev' onclick = 'calUtil.drawOtherMonth(" + iYear + "," + iMonth + " , \"prev\")';>&nbsp;</div>");
		htmls.push("<div class='calendar_month_span'>" + iYear + "年 " + iMonth + " 月</div>");
		htmls.push("</div>");
		htmls.push("<div class='sign' id='sign_cal'>");
		htmls.push("<table>");
		htmls.push("<tr>");
		htmls.push("<th>" + myMonth[0][0] + "</th>");
		htmls.push("<th>" + myMonth[0][1] + "</th>");
		htmls.push("<th>" + myMonth[0][2] + "</th>");
		htmls.push("<th>" + myMonth[0][3] + "</th>");
		htmls.push("<th>" + myMonth[0][4] + "</th>");
		htmls.push("<th>" + myMonth[0][5] + "</th>");
		htmls.push("<th>" + myMonth[0][6] + "</th>");
		htmls.push("</tr>");
		var d, w;
		for (w = 1; w < 7; w++) {
			htmls.push("<tr>");
			for (d = 0; d < 7; d++) {
				var ifHasSigned = calUtil.ifHasSigned( signList, iYear, iMonth ,myMonth[w][d]);
				if (ifHasSigned) {
					htmls.push("<td class='on'>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : "&nbsp;") + "</td>");
				} else {
					htmls.push("<td>" + (!isNaN(myMonth[w][d]) ? myMonth[w][d] : "&nbsp;") + "</td>");
				}
			}
			htmls.push("</tr>");
		}
		htmls.push("</table>");
		htmls.push("</div>");
		htmls.push("</div>");
		return htmls.join('');
	},
	doSign : function(url, y, m) {
		showLoading("正在签到...");
		$.ajax({
			url : url,
			type : "POST",
			dataType : "json",
			success : function(data) {
				loadingComplete();
				var rst = data.result;
				if (rst == 1) {
					showError("今天您已经签到，无须再次签到！", function() {
						calUtil.render(y, m);
					});
				} else if (rst == 0) {
					showSuccess("签到成功！", function() {
						calUtil.render(y, m);
					});
				} else {
					calUtil.render(y, m);
				}
			}
		});
	},
	render : function(y, m) {
		$.ajax({
			url : ctx + "/sign/getSignList",
			data : {"year": y , "month" : m},
			type : "POST",
			dataType : "json",
			success : function(data) {
				var signList = data.signList;
				var str = calUtil.drawCal(y, m, signList);
				if($("#sign_layer").length > 0) {
					$("#sign_layer").html(str);
				} else {
					$("<div id='sign_layer' >" + str + "</div>").layerModel({ title : "签到日历" });
				}
			}
		});
	},
	drawOtherMonth : function(y , m ,tag){
		if(tag == "next") {
			if(m == 12) {
				y = y + 1;
				m = 1;
			} else {
				m = m + 1;
			}
		}
		if(tag == "prev") {
			if(m == 1) {
				y = y - 1;
				m = 12;
			} else {
				m = m - 1;
			}
		}
		calUtil.render( y, m );
	}
};