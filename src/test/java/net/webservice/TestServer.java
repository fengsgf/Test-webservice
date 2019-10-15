package net.webservice;

import javax.xml.ws.Endpoint;

public class TestServer {

	public static void main(String[] args) {
		/** 参考文章： https://segmentfault.com/a/1190000013806509 */
		UserService userService = new UserServiceImpl();
	    String address1="http://127.0.0.1:9281/ws/userService";
		Endpoint.publish(address1, userService);
	}
	
}
