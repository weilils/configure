package com.o2o.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.o2o.dao.ShopDao;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.enumes.ShopEnume;
import com.o2o.service.ShopService;
import com.o2o.service.exception.ShopOpreateException;
import com.o2o.utool.ImgUtil;
import com.o2o.utool.PageUtil;
import com.o2o.utool.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private ShopDao shopdao;

	@Override
	@Transactional // 表示该方法是事务
	public ShopExecution addShop(Shop shop, InputStream imgInputStream, String filename) {
		// 判断传入的shop对象是否为空
		if (shop == null)
			return new ShopExecution(ShopEnume.SHOPNOTEXIT);
		try { /* 为新创建的shop的一些固定的属性进行赋值并将其存入数据库 */
			shop.setCreatetime(new Date());
			shop.setLast_modifytime(new Date());
			shop.setEnable_status(1);
			int effectNum = shopdao.addShop(shop);
			if (effectNum < 0)// 表示插入数据失败
			{
				/* 抛出运行时异常，事务会终止执行，并回滚 */

				throw new ShopOpreateException("插入数据失败!");
			} else// 表示插入成功
			{
				if (imgInputStream != null) {
					try {
						storageImg(shop, imgInputStream, filename);// 传递的数据引用类型
						shopdao.updateShop(shop);// 更新店铺的图片信息
					} catch (Exception e) {
						// TODO: handle exception
						/* 抛出运行时异常，事务会终止执行，并回滚 */
						throw new ShopOpreateException("更新图片失败!");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ShopOpreateException("addShopError:" + e.toString());
		}
		/* 插入正常的数据，返回店铺审核中，以及店铺的实体 */
		return new ShopExecution(ShopEnume.CHECK, shop);
	}

	private void storageImg(Shop shop, InputStream fileInputStream, String filename) {
		// TODO Auto-generated method stub
		logger.debug("start");
		String Reladdress = PathUtil.getShopImgRootPath(shop.getId());
		String imgAddress = ImgUtil.generateThumbnails(fileInputStream, filename, Reladdress);
		logger.info(imgAddress);
		shop.setImag(imgAddress);
	}

	@Override
	public ShopExecution mdifyShop(Shop shop, InputStream img, String filename) {
		try {
			/* 如果没有Shop的Id 直接返回错误信息 */
			if (shop.getId() == null) {
				return new ShopExecution(ShopEnume.SHOPIDNOTFOUND);
			}
			String filenametmp = getShopInf(shop.getId()).getImag();
			/* 如果需要处理图片 */
			if (img != null && filename != null && !"".equals(filename)) {
				if (filenametmp != null) {
					ImgUtil.deleteOldImg(
							PathUtil.getImgRootPath() + PathUtil.getShopImgRootPath(shop.getId()) + filenametmp);
				}
				storageImg(shop, img, filename);
			}
			shop.setLast_modifytime(new Date());// 将修改时间修改为最新
			int effectNum = shopdao.updateShop(shop);
			if (effectNum != 1) {
				throw new ShopOpreateException(ShopEnume.INNERERROR.getStatusInf());
			}
			return new ShopExecution(ShopEnume.CHECK, shopdao.getShopInfo(shop.getId()));
		} catch (Exception e) {
			// TODO: handle exception
			throw new ShopOpreateException("ShopModifyError:" + e.getMessage());
		}
	}

	@Override
	public Shop getShopInf(Long Id) {

		return shopdao.getShopInfo(Id);
	}

	@Override
	public ShopExecution getShopList(Shop shop, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		int ShopStartIndex = PageUtil.CoverpageToIndex(pageNum, pageSize);
		List<Shop> shoplist = shopdao.getShopList(shop, ShopStartIndex, pageSize);
		int shopNum=shopdao.getSelectSize(shop);
		ShopExecution execution;
		if (shoplist != null) {
			/* 获取店铺列表成功时返回店铺列表，以及状态信息*/
			execution = new ShopExecution(ShopEnume.CHECK, shoplist);
			execution.setShopNum(shopNum);
			} else {
			execution = new ShopExecution(ShopEnume.INNERERROR);// 获取店铺列表失败时返回错误信息
		}
		return execution;
	}
}
