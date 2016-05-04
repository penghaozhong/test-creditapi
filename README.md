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

##git项目下载流程:

> eclipse git 使用:  http://my.oschina.net/u/933822/blog/369640?fromerr=z2asb8xh
> > 转换为mavrn项目: 项目 -> 右键 -> Configure-> Convert to Maven Project


### 通讯信用评分查询接口, 返回示例:

```

{"finishTime":"2016-05-04 15:05:08","resCode":200,"resMsg":"请求成功","timeDiff":188}

{
    "batchCode":"61b2a47edc6d4f7bb6ebd1524b23bf7b",
    "finishTime":"2016-05-04 14:56:40",
    "resCode":200,
    "resMsg":"请求成功"
}

```

### 通讯信用评分结果接口, 返回示例: 
```
{"finishTime":"2016-05-03 15:56:49","resCode":200,"resMsg":"请求成功","timeDiff":686}

请求成功示例:

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 11:17:11",
    "resCode":200,
    "resMsg":"请求成功",
    "result": [        
         {
            "caseId":"009411694e05415d9c850ac311358192",
            "customerIdNumber":"310228198509252611",
            "customerMobile":"13331801313",
            "customerName":"陆逢源",
            "queryTime":"2016-05-04 09:47:05",
            "score":20
        },{
            "caseId":"560b7d9280294a488aca55d883b5f495",
            "customerIdNumber":"310110197201123211",
            "customerMobile":"13331927176",
            "customerName":"李琦峰",
            "queryTime":"2016-05-04 09:47:12",
            "score":30
        },{
            "caseId":"6e977fa292de4e3b9e859a3deb4b5508",
            "customerIdNumber":"510781198512183553",
            "customerMobile":"18917929911",
            "customerName":"刘伟",
            "queryTime":"2016-05-04 09:47:08",
            "score":40
        }]
}


请求失败示例:

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":47002,
    "resMsg":"暂时无数据返回,请稍后查询"
}

```
