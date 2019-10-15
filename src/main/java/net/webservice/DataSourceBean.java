package net.webservice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.activation.DataSource;

public class DataSourceBean implements DataSource, Serializable {
	private static final long serialVersionUID = 1L;
	private byte[] bs;
	public DataSourceBean(byte[] bs) {
		this.bs = bs;
	}
	@Override
	public OutputStream getOutputStream() throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		return bos;
	}
	@Override
	public String getName() {
		return "file";
	}
	@Override
	public InputStream getInputStream() throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
		return bis;
	}
	@Override
	public String getContentType() {
		return "123";
	}

}
