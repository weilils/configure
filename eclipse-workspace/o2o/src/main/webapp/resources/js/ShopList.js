/**
 * 
 */
$(function() {
	var Initalurl ='/o2o/shopadmin/getshoplist';
	Inital();
	function Inital() {
		$.getJSON(Initalurl, function(data) {
			if (data.success) {
				var cata_groyHtml = '';
				var usernam='';
				data.shopList.map(function(item, index) {
					cata_groyHtml += "</div><div class='row bord'> <div class='col-40'>"+item.name+"</div><div class='col-40'>"+getStatus(item.enable_status)+"</div><div class='col-20'>"+getUrl(item,item.enable_status)+"</div></div>";
				});
				username=data.username;
				
			} else {
				alert(data.errorMsg);
			}
			$('#content').append(cata_groyHtml);// 使用id选择器
			$('#username').append(username);
		});// function为回调方法
	}
	function getStatus(k)
	{
		if(k==-1)
			return "店铺非法 ";
		else if(k==1)
			return "审核中 ";
		else if(k==0)
			return "运营中";
		else
			return "已下架";
	}
	function getUrl(shop,status)
	{
		if(status==1||status==0)
			//return "<a href='/o2o/index.html'>test</a>";
			return "<a href='/o2o/shop/ShManager?shopid="+shop.id+"'>管理</a>";
			//return "<a href='/o2o/shop/shopOpreation?shopid="+shop.id+"'>管理</a>";
		else
		{
			return '不可操作';
		}
		
	}
});