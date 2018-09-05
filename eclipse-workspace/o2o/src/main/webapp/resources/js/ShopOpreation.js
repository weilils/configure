$(function() {
	var getInstallUrl = '/o2o/shopadmin/oinitalSouce';
	var posInformation = "/o2o/shopadmin/register";
	var modifyUrl = '/o2o/shopadmin/modifyshop';
	var getShopInf = '/o2o/shopadmin/getshopinf';
	var shop_id = getQueryString('shopid');
	var isEdit = shop_id ? true:false;
	// 根据是否传入shopid选择调用初始化方法
	if (!isEdit) {
		getAreaCatagroyInformation();
	} else {
		getShopInformation();
	}
	function getShopInformation() {
		$.ajax({
			url : getShopInf,
			type : 'GET',
			datType : "JSON",
			data : {
				'shopid' : shop_id
			},
			success : function(data) {// 从后台返回的json串
				if (data.success) {
					var shopinf = data.shop;
					var area_html = '';
					/* 不能修改shop所属的目录 */
					var cata_groyHtml = '<option data-id='
							+ shopinf.catagray.id + '>' + shopinf.catagray.name
							+ '</option>';
					data.arealist.map(function(item, index) {
						area_html += '<option data-id=' + item.id + '>'
								+ item.name + '</option>';
					});// 调用map中的函数的数组进行处理
					$('#shopid').val(shopinf.name);
					$('#shopAddress').val(shopinf.address);
					$('#shopContact').val(shopinf.contact_inf);
					$('#desc').val(shopinf.description);
					console.log(cata_groyHtml);
				} else {
					alert(data.errorMsg);
				}
				$('#catagroy_id').html(cata_groyHtml);// 使用id选择器
				$('#area_id').html(area_html);
				/* 根据id设置地点 */
				$("#area_id option[data-id='" + shopinf.area.id + "']").attr(
						'selected', 'selected');
			}
		});
	}
	function getAreaCatagroyInformation() {
		/* 回调方法在成功时调用 */
		$.getJSON(getInstallUrl, function(data) {
			if (data.success) {
				var cata_groyHtml = '';
				var area_html = '';
				data.shopCata_groyList.map(function(item, index) {
					cata_groyHtml += '<option data-id=' + item.id + '>'
					+ item.name + '</option>'
				});
				data.areaList.map(function(item, index) {
					area_html += '<option data-id=' + item.id + '>' + item.name
							+ '</option>';
				});// 调用map中的函数的数组进行处理
				console.log(cata_groyHtml);
			} else {
				alert(data.errorMsg);
			}
			$('#catagroy_id').append(cata_groyHtml);// 使用id选择器
			$('#area_id').html(area_html);
		});// function为回调方法
	}
	$('#submit').click(function() {
		var shop = {};
		var area = {};
		var catagroy = {};
		if (isEdit) {
			shop.id = shop_id;
		}
		shop.name = $('#shopid').val();
		catagroy.id = $('#catagroy_id  option').not(function() {
			return !this.selected
		}).attr('data-id');// 获取被选中的option的id
		area.id = $('#area_id  option').not(function() {
			return !this.selected
		}).attr('data-id');// zepto 获取select选中的值
		shop.catagray = catagroy;
		shop.area = area;
		shop.address = $('#shopAddress').val();
		shop.contact_inf = $('#shopContact').val();
		shop.description = $('#desc').val();
		var img = $('#shopImg')[0].files[0];// 获取文件流
		var fromData = new FormData();
		fromData.append('shopimg', img);
		fromData.append('shopName', JSON.stringify(shop));// 将shop序列化为json
		var J_kaptcha = $("#num_kapcha").val();
		console.log($("#num_kapcha").val());
		if (J_kaptcha != null) {
			console.log(J_kaptcha);
			fromData.append('J_kaptcha', J_kaptcha);
		} else {
			$.toast("请输入验证码!");
			return;
		}

		$.ajax({
			url : isEdit ? modifyUrl : posInformation,
			type : 'POST',
			contentType : false,
			async : false,
			cache : false,
			processData : false,
			data : fromData,
			success : function(data) {// 从后台返回的json串
				if (data.success) {
					$.toast("提交成功!");
				} else {
					$.toast("提交失败！" + data.errorMsg);
				}
				$('#kaptcha_img').click();
			}
		});
	});
})
