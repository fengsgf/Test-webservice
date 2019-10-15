package net.webservice;

import javax.activation.DataHandler;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Before;
import org.junit.Test;

import com.sun.istack.internal.ByteArrayDataSource;

/**
 * 可以使用命令在客户端生成请求参数的类（jdk的版本最好是1.7或以上）： wsimport [opations] <wsdl_uri> ；
 * wsdl_uri:wsdl 的统一资源标识符
 * d  ：指定要输出的文件的位置
 * s  ：表示要解析java的源码 ，默认解析出的是class字节码 
 * p  ： 指定输出的包名
 */
public class TestClient {

	Client client;
	
	@Before
	public void init() {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		client = dcf.createClient("http://127.0.0.1:9281/ws/userService?wsdl");
	}
	
	@Test
	public void getName() throws Exception {
		Object[] objects = client.invoke("getName", "2134");
		System.out.println("======result:" + objects[0]);
	}

	@Test
	public void upload1() throws Exception {
		byte[] bs = {1,2,3};
		Object[] objects2 = client.invoke("uplaod1", bs);
		System.out.println("======result:" + objects2[0]);
	}

	@Test
	public void upload2() throws Exception {
		byte[] bs = {1,2,3};
		ByteArrayDataSource dataSoource = new ByteArrayDataSource(bs, null);
//		DataHandler handler = new DataHandler(new DataSourceBean(bs));
		DataHandler handler = new DataHandler(dataSoource);
		Object[] objects2 = client.invoke("uplaod2", handler);
		System.out.println("======result:" + objects2[0]);
	}

	@Test
	public void upload3() throws Exception {
		byte[] bs = {1,1,2,3,4};
		ByteArrayDataSource dataSoource = new ByteArrayDataSource(bs, null);
//		DataHandler handler = new DataHandler(new DataSourceBean(bs));
		DataHandler handler = new DataHandler(dataSoource);
		UploadRequest3 request = new UploadRequest3(handler, "sgf");
		Object[] objects2 = client.invoke("uplaod3", request);
		System.out.println("======result-uplaod3:" + objects2[0]);
	}

	@Test
	public void upload4() throws Exception {
		byte[] bs = {1,1,2,3,4};
		UploadRequest4 request = new UploadRequest4(bs, "sgf");
		Object[] objects2 = client.invoke("uplaod4", request);
		UploadRequest4 response = (UploadRequest4)objects2[0];
		System.out.println("======result-uplaod4:" + response.getFile().length);
	}

	@Test
	public void upload5() throws Exception {
		byte[] bs = {1,1,2,3,4};
		UploadRequest4 request = new UploadRequest4(bs, "sgf");
		Object[] objects2 = client.invoke("uplaod5", request);
		byte[] response = (byte[])objects2[0];
		System.out.println("======result-uplaod5:" + response.length);
	}

	@Test
	public void superParamTest() throws Exception {
		byte[] bs = {1,1,2,3,4};
		UploadRequest5 request = new UploadRequest5(bs, "sgf", "test");
		Object[] objects2 = client.invoke("superParamTest", request);
		String response = (String)objects2[0];
		System.out.println("======result-uplaod5:" + response);
	}
	
	@Test
	public void download() throws Exception {
		Object[] objects3 = client.invoke("download");
		System.out.println("======result:" + objects3[0]);
	}


}
