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


### 查询接口:

```

{"finishTime":"2016-05-04 15:05:08","resCode":200,"resMsg":"请求成功","timeDiff":188}

{
    "batchCode":"61b2a47edc6d4f7bb6ebd1524b23bf7b",
    "finishTime":"2016-05-04 14:56:40",
    "resCode":200,
    "resMsg":"请求成功"
}

```

### 结果接口: 
```
{"finishTime":"2016-05-03 15:56:49","resCode":200,"resMsg":"请求成功","timeDiff":686}

请求成功示例:

{
    "batchCode": "d70e8f9978174668b0fa758eea5d6db7",
    "finishTime": "2016-05-04 20:16:28",
    "jsonList": "K-qZBlmp5SWMDI0APeAuPdzrh3TEODWKMrxMzuhh4R6BWdNEQTM0VOcjNS1a-JtAhPS3GTBsQOKmo2Lo2X-_mLSsKMv-kZ7QkxjPPI9BbtQt0h7Fzz2QZrKNN5q8f4gFeHwHSHgVxiZfemwlGPlLYHCUhHmk5Zv3P2pe4mIaIhMW7CM59wloSm21LnwDaKPrKfL1tTpHIwbSfX-DpbTjkNvnPip2kvRG7iq2WHizZc2aHe6599hwgGt_HGM9T7gDGxKW8-IdtYgGMvEb2aGj0fK_Jz5vNDtWmeEt5NLOngXLDgAyZYABUVShD2ezngdzjdfUmNok34t_YTvLnggkU1zEWNoGKyCAAXsYGKOwdqex_XgO30FsdyOkj1s89NKYWhXtoSD-2-41Fk7uMmySBfQ4HAvr8lYultZdkV-YfBEkuRmybhnkt9E-l6Pe9NEPgEuq3tD2ecgwNADf2FTWZDUK52qidckMv2S4OXRSYBiCaA0ooVXIADvRasSKfSeE5KfPuufEUdeYA61INAqaaBzlNUONYlQ5M3uMee9PzXsJOSKBjYUoUnasSnSuO1YXgVlAMsDoF8K_kTnj7AsmNGk19mUExoODh0_cix2PTyKMyMoxSGLfXbDtikTu647CA7mD9opG2NqSvAzqUiF6I8AYnUgQSexqLP4jNQQRybbGdiFawVIu_0MZxdC0XVLRf3jo6u6DZkDBknw0Db9S9LODZ-qF58fifTG6uC24yQDEmKkJbDIk2XRDoKv8AtOV",
    "resCode": 200,
    "resMsg": "请求成功"
}


请求失败示例:

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":47000,
    "resMsg":"时间间隔超过一分钟, 请重新鉴定时间间隔"
}

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":47001,
    "resMsg":"网络传输过程中签名不匹配, 数据丢失"
}


{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":47002,
    "resMsg":"暂时无数据返回,请稍后查询"
}

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":40004,
    "resMsg":"不合法的参数"
}

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":40008,
    "resMsg":"公司密钥不正确!"
}

{
    "batchCode":"0266aa2f23c04dc7b2f1043afda2b1fb",
    "finishTime":"2016-05-04 10:49:03",
    "resCode":47011,
    "resMsg":"查询批次号batchCode不允许为空"
}

```
