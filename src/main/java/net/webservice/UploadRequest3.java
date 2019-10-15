package net.webservice;

import java.io.Serializable;

import javax.activation.DataHandler;

public class UploadRequest3 implements Serializable {
	private static final long serialVersionUID = 1L;

	private DataHandler file;
	private String name;
	
	public UploadRequest3() {}
	public UploadRequest3(DataHandler file, String name) {
		this.file = file;
		this.name = name;
	}
	
	public DataHandler getFile() {
		return file;
	}
	public void setFile(DataHandler file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
