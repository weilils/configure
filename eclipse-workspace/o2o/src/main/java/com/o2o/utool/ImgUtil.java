package com.o2o.utool;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImgUtil {
	/*获取文件的扩展名称*/
	public  static String getFileExtend(String FileName)
	{
		return FileName.substring(FileName.lastIndexOf('.'));
	}
	/*创建目标文件*/
	public static void MakeDir(String targetAddress)
	{
		File file = new File(targetAddress);  
		if(!file.exists()){  
		    file.mkdirs();  
		} 
	}
	/*采用随机数来命名文件*/
	public static String RandomFilename()
	{
		Random random=new Random();
		Date date=new Date();
		String FileName=String.valueOf(date.getTime())+random.nextInt(100000);
	    return FileName;
	}
	/*将上传的文件保存为缩略图,并返回文件的绝对路径*/
	public static String generateThumbnails(InputStream fileInutStream,String filename,String targetAddress)
	{
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String ExtendName=getFileExtend(filename);
		String FileName=RandomFilename();
		MakeDir(PathUtil.getImgRootPath()+targetAddress);
		String relatePath=targetAddress+"/"+FileName+ExtendName;
		File file2=new File(PathUtil.getImgRootPath()+relatePath);
		try
		{
			//生成缩略图并添加水印，并保存到文件file2中
			Thumbnails.of(fileInutStream).size(200,200).watermark(Positions.BOTTOM_LEFT,ImageIO.read(new File(basePath+"/mywatermark.png")),0.25f).outputQuality(0.8).toFile(file2);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return file2.getName();
	}
	/*采用File参数重载,可以方便单元测试*/
	public static String generateThumbnails(File file,String targetAddress)
	{
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String ExtendName=getFileExtend(file.getName());
		String FileName=RandomFilename();
		MakeDir(PathUtil.getImgRootPath()+targetAddress);
		String relatePath=targetAddress+"/"+FileName+ExtendName;
		File file2=new File(PathUtil.getImgRootPath()+relatePath);
		try
		{
			//生成缩略图并添加水印，并保存到文件file2中
			Thumbnails.of(file).size(200,200).watermark(Positions.BOTTOM_LEFT,ImageIO.read(new File(basePath+"/mywatermark.png")),0.25f).outputQuality(0.8).toFile(file2);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return file2.getName();
	}
	/*测试功能是否可用*/
	public static void main(String []args) throws IOException
	{
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//System.out.print(basePath);
		Thumbnails.of(new File(basePath+"/front.png")).size(200,200).watermark(Positions.BOTTOM_LEFT,ImageIO.read(new File(basePath+"/mywatermark.png")),0.25f).outputQuality(0.8).toFile(new File("D:/myimg_test.png"));
	}
	public static void deleteOldImg(String imgPath)
	{
		File oldFile=new File(imgPath);
		if(oldFile.exists())
		{
			/*判断路径是否为文件夹*/
			if(oldFile.isDirectory())
			{
				File []files=oldFile.listFiles();
				for(int i=0;i<files.length;i++)
				{
					files[i].delete();
				}
			}
			oldFile.delete();	
		}
	}
}
