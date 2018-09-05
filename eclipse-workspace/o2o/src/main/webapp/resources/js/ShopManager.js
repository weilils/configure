/**
 * 
 */
$(function() {
	var shopid = getQueryString('shopid');
	var Initalurl = '/o2o/shopadmin/getshopmanagerinf?shopid='+shopid;
	Inital();
	function Inital() {
		$.getJSON(Initalurl, function(data) {
			if (data.success) {
				if (data.redirect) {
					window.location.href = data.url;
				} else {
					if (data.currentShopId != undefined
							&& data.currentShopId != null) {
						shopid = data.currentShopId;
					}
				}
				$('#shopadmin').attr('href','/o2o/shop/shopOpreation?shopid='+shopid);// 使用id选择器
			} else {
				alert(data.errorMsg)
			}
		});// function为回调方法
	}
});