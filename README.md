# test-creditapi
用户测试webapi Demo    
##使用注意事项

	1.key 修改为自己公司的key
	2.公司ID，密钥在注册后会发送到注册联系邮箱中
	3.有问题请咨询相关工作人员 联系QQ 398752075
##错误信息参考
**异常java.security.InvalidKeyException:illegal Key Size的解决方案,官方网站提供了JCE无限制权限策略文件的下载:**
* JDK6的下载地址：   http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html
* JDK7的下载地址：    http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
* 下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt。
* 如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security下覆盖原来文件，记得先备份。
* 如果安装了JDK，将两个jar文件也放到%JDK_HOME%\jre\lib\security下。
