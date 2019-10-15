package net.webservice;

import java.io.IOException;

import javax.activation.DataHandler;


public class UserServiceImpl implements UserService {

	@Override
	public String getName(String id) {
		System.out.println("------调用getName,id:" + id);
		return id + "_name";
	}

	@Override
	public int uplaod1(byte[] file) {
		System.out.println("------调用uplaod1,length:" + file.length);
		return file.length;
	}

	@Override
	public int uplaod2(DataHandler file) {
		System.out.println("------调用uplaod2");
		int length = 0;
		try {
			length = file.getInputStream().available();
			System.out.println("------调用uplaod,file.size:" + length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return length;
	}

	@Override
	public DataHandler download() {
		byte[] bs = {1,2};
		return new DataHandler(new DataSourceBean(bs));
	}

	@Override
	public UploadRequest3 uplaod3(UploadRequest3 request) {
		int length = 0;
		try {
			DataHandler dataHandler = request.getFile();
			if(dataHandler != null) {
				length = dataHandler.getInputStream().available();
			}
			System.out.println("------调用uplaod3,file.size:" + length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UploadRequest3(request.getFile(), request.getName() + "-res");
	}

	@Override
	public UploadRequest4 uplaod4(UploadRequest4 request) {
		int length = 0;
		try {
			byte[] file = request.getFile();
			if(file != null) {
				length = file.length;
			}
			System.out.println("------调用uplaod4,file.size:" + length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UploadRequest4(request.getFile(), request.getName() + "-res");
	}

	@Override
	public byte[] uplaod5(UploadRequest4 request) {
		int length = 0;
		try {
			byte[] file = request.getFile();
			if(file != null) {
				length = file.length;
			}
			System.out.println("------调用uplaod4,file.size:" + length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request.getFile();
	}

	@Override
	public String superParamTest(UploadRequest5 request) {
		return request.getParam1();
	}

}
