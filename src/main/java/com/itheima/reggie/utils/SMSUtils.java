package com.itheima.reggie.utils;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.*;

/**
 * 短信发送工具类
 */
public class SMSUtils {
	public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
		com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
				// 必填，您的 AccessKey ID
				.setAccessKeyId("LTAI5tFsWFsCas2dEn1RXDuv")
				// 必填，您的 AccessKey Secret
				.setAccessKeySecret("bfAiyWJaJshwrVv7bFWN3XSQADHmDE");
		// 访问的域名
		config.endpoint = "dysmsapi.aliyuncs.com";
		return new com.aliyun.dysmsapi20170525.Client(config);
	}

	public static void sendMessage(String[] args_) throws Exception {
		java.util.List<String> args = java.util.Arrays.asList(args_);
		// 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
		com.aliyun.dysmsapi20170525.Client client = SMSUtils.createClient("accessKeyId", "accessKeySecret");
		com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
				.setSignName(args_[0])
				.setTemplateCode(args_[1])
				.setPhoneNumbers(args_[2])
				.setTemplateParam("{\"code\":\""+args_[3]+"\"}");
		com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
		try {
			// 复制代码运行请自行打印 API 的返回值
			SendSmsResponse response = client.sendSmsWithOptions(sendSmsRequest, runtime);
			System.out.println(response.getBody());
		} catch (TeaException error) {
			// 如有需要，请打印 error
			com.aliyun.teautil.Common.assertAsString(error.message);
		} catch (Exception _error) {
			TeaException error = new TeaException(_error.getMessage(), _error);
			// 如有需要，请打印 error
			com.aliyun.teautil.Common.assertAsString(error.message);
		}
	}
}