package net.webservice;

public class UploadRequest5 extends BaseRequest /*implements Serializable*/ {

	private byte[] file;
	private String name;
	
	public UploadRequest5() {
		super(null);
	}
	
	public UploadRequest5(byte[] file, String name, String param1) {
		super(param1);
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
