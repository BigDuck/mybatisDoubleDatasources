/*
 * Copyright (c) 2015 / 8 / 11 11 :2 :40
 * BY:wupeiji
 * QQ:757671834
 *
 */

var loadingImg = ctx ;
/**
 * loading主方法
 */
function showLoading(msgTip) {
	var wid = "150px";
	var htmlstr = "<div class='layerModel_loading' style='width : " + wid + "'>" + "<img src='" + loadingImg + "/images/loading3.gif'/>";
	if (msgTip != null && msgTip != undefined) {
		htmlstr += "<span class='msg_tip'>" + msgTip + "</span>";
	}
	htmlstr += "</div>";
	$(htmlstr).layerModel({
		"head" : false
	});
}
/**
 * 关闭loading
 */
function loadingComplete() {
	$(".layerModel_loading").close();
}

function layerAlert(msg, callback) {
	if (msg == null || msg == undefined) {
		msg = "消息没有提示语啊!";
	}
	var sInner = '<div class="layer_alert" id="layer_alert">'
			+ '	<div class="layer_alert_content">' + msg + '</div>'
			+ '	<div class="layer_alert_btn_bar">'
			+ '		<input type="button" class="btn_sure" value="确定">' + '	</div>'
			+ '</div>';
	$(sInner).layerModel();
	$("#layer_alert .btn_sure").click(function() {
		if (callback) {
			callback();
		}
		$("#layer_alert").close();
	});
}

function layerConfirm(msg, callback) {
	if (msg == null || msg == undefined) {
		msg = "消息没有提示语啊!";
	}
	var sInner = '<div class="layer_alert" id="layer_confirm">'
			+ '	<div class="layer_alert_content">'
			+ msg
			+ '</div>'
			+ '	<div class="layer_alert_btn_bar">'
			+ '		<input type="button" class="btn_highlight" value="确定">'
			+ '		<input type="button" class="btn_normal" value="取消" onclick="$(\"#layer_confirm\").close()">'
			+ '	</div>' + '</div>';
	$(sInner).layerModel();
	$("#layer_confirm .btn_sure").click(function() {
		if (callback) {
			callback();
		}
		$("#layer_confirm").close();
	});
}

/**
 * 显示错误信息
 * 
 * @param msg
 */
function showError(msg, callBack) {
	var htmls = "<div id='gwc_fail' class='gwc_mes_box'><div class='tb_cart_head_fail'></div>";
	htmls += "<div class='tb_cart_head_fail_txt'>" + msg + "</div>";
	htmls += "<div class='tb_cart_sure'>";
	htmls += "<a href='javascript:$(\"#gwc_fail\").close();' class='tb_cart_checkout' title='确定'>确定</a>";
	htmls += "</div></div>";
	$(htmls).layerModel({
		staySame : true,
		close : function() {
			if (callBack != null && callBack != undefined) {
				if (typeof callBack == "function") {
					callBack();
				} else {
					window.location.href = callBack;
				}
			}
			return true;
		}
	});
}
/**
 * 显示成功信息
 * 
 * @param msg
 * @param url
 * @return
 */
function showSuccess(msg, callBack) {
	var htmls = "<div id='gwc_succ' class='gwc_mes_box'><div class='tb_cart_head_succ'></div>";
	htmls += "<div class='tb_cart_head_succ_txt'>" + msg + "</div>";
	htmls += "<div class='tb_cart_sure'>";
	htmls += "<a href='javascript:$(\"#gwc_succ\").close();' class='tb_cart_checkout' title='确定'>确定</a>";
	htmls += "</div></div>";
	$(htmls).layerModel({
		staySame : true,
		close : function() {
			if (callBack != null && callBack != undefined) {
				if (typeof callBack == "function") {
					callBack();
				} else {
					window.location.href = callBack;
				}
			}
			return true;
		}
	});
}

