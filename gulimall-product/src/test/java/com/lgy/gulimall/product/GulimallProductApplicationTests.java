package com.lgy.gulimall.product;

import com.aliyun.oss.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lgy.gulimall.product.entity.BrandEntity;
import com.lgy.gulimall.product.service.BrandService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootTest
class GulimallProductApplicationTests {

	@Autowired
	private OSSClient ossClient;

	@Autowired
	private BrandService brandService;

	@Test
	public void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setDescript("这是商品的描述2");
//		brandEntity.setName("品牌的名字2");
//		brandService.save(brandEntity);
//		System.out.println("保存成功...");

		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 2L));
		list.forEach((item)->{
			System.out.println(item);
		});
	}

	@Test
	public void testUpload(){

				// Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//				String endpoint = "https://oss-cn-beijing.aliyuncs.com";
//				// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//				String accessKeyId = "LTAI5tJyJsmpWJFd6CTUh48V";
//				String accessKeySecret = "AqN65J0Xa3NujWLsNgwwpfxuT4r8h5";
				// 填写Bucket名称，例如examplebucket。
				String bucketName = "gulimall-lgy";
				// 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
				String objectName = "4139f97a459c4f293607f3cb9a465e8b.jpg";
				// 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
				// 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
				String filePath= "C:\\Users\\LGY\\Pictures\\pic\\4139f97a459c4f293607f3cb9a465e8b.jpg";

				// 创建OSSClient实例。
				//OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

				try {
					InputStream inputStream = null;
					try {
						inputStream = new FileInputStream(filePath);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					// 创建PutObject请求。
					ossClient.putObject(bucketName, objectName, inputStream);

					System.out.println("上传成功");
				} catch (OSSException oe) {
					System.out.println("Caught an OSSException, which means your request made it to OSS, "
							+ "but was rejected with an error response for some reason.");
					System.out.println("Error Message:" + oe.getErrorMessage());
					System.out.println("Error Code:" + oe.getErrorCode());
					System.out.println("Request ID:" + oe.getRequestId());
					System.out.println("Host ID:" + oe.getHostId());
				} catch (ClientException ce) {
					System.out.println("Caught an ClientException, which means the client encountered "
							+ "a serious internal problem while trying to communicate with OSS, "
							+ "such as not being able to access the network.");
					System.out.println("Error Message:" + ce.getMessage());
				} finally {
					if (ossClient != null) {
						ossClient.shutdown();
					}
				}
			}

}
