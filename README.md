# Micro-Service SpringCloud
微服务开发

## 工程说明

 1. EurekaServer,EurekaServer2:注册中心，两个注册中心可以做集群
 2. microserviceitem,microserviceitem2,:商品微服务2个
 2. microserviceorder: 订单微服务
 3. microserviceconfigserver：配置微服务
 4. microsrviceapigateway：网关微服务


## 2.操作
   2.1在GitHub上创建文件夹MySpringCloud/springcloudconfig，再创建配置文件properties、yml，放置配置文件。
   2.2先启动 EurekaServer，再启动microserviceconfigserver，再启动microserviceitem，microserviceorder，microsrviceapigateway
   2.3
    注册中心：http://localhost:8100/
	![这里写图片描述]()
	
    网关swagger:http://localhost:8087/swagger-ui.html
	![这里写图片描述]()
   2.4
    在GitHub的项目MySpringCloud 右上角Settings 可以在Webhooks配置回调地址 http://localhost:8080/actuator/refresh
    用户更改配置文件后再推送到后，可以不用重启项目，可以读取更改的配置属性值。
	如果本地的地址配置访问不了，可以通过穿透工具进行访问
	如果手动Post请求http://localhost:8080/actuator/refresh成功
	在GitHub上配置后推送回调不成功（返回转态出现json问题）。可以把Webhooks配置的地址先配置成其它接口地址如refreshconfig，再请rerfreshconfig接口去Post请求http://localhost:8080/actuator/refresh 实现更新配置内容
	
	

