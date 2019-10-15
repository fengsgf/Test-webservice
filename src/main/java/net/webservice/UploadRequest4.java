package net.webservice;

import java.io.Serializable;

public class UploadRequest4 implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte[] file;
	private String name;
	
	public UploadRequest4() {}
	public UploadRequest4(byte[] file, String name) {
		this.file = file;
		this.name = name;
	}
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
