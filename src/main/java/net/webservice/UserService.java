package net.webservice;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService
public interface UserService {

	/** 请求参数和返回参数均为 String */
	String getName(String id);

	/** 请求参数为 byte[] 返回参数均为 int */
	int uplaod1(byte[] file);

	/** 请求参数为 DataHandler 返回参数均为 int */
	int uplaod2(@XmlMimeType("*/*")DataHandler file);

	/** 请求参数为 类（包括DataHandler 和 String） 返回参数均为 类（包括DataHandler 和 String） */
	UploadRequest3 uplaod3(UploadRequest3 request);

	/** 请求参数为 类（包括byte[] 和 String） 返回参数均为 类（包括byte[] 和 String） */
	UploadRequest4 uplaod4(UploadRequest4 request);

	/** 请求参数为 类（包括byte[] 和 String） 返回参数均为 byte[] */
	byte[] uplaod5(UploadRequest4 request);

	/** 请求参数为 子类（包括byte[] 和 String，父类的参数 String，不序列化） 返回参数均为 String */
	String superParamTest(UploadRequest5 request);

	/** 返回参数均为 DataHandler */
	@XmlMimeType("*/*")
	DataHandler download();
}
