package com.o2o.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*配置spring 和 junit ，junit启动时加载IOC容器*/
@RunWith(SpringJUnit4ClassRunner.class)
/*加载配置文件由于dao层的实例有mybatis负责创建,所以在测试service层时必须引入dao层的配置文件
 * 
 * 
 */
@ContextConfiguration(locations={"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class BaseTest {

}
