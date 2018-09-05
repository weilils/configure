/**
 * 
 */
function changeVerifyCode(img) {
	/* Math.floor向下取整，Math.floor(Math.random()*100)随机性更强 */
	img.src = "/o2o/Kaptcha?" + Math.floor(Math.random() * 100);// Math.random()产生0-1间的任意数如0.872525005541986

}
/* 获取对应参数的值(通过Url提交) */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {

		return decodeURIComponent(r[2]);
	}
	return '';

}