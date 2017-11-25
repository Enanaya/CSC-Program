package net.ip;

import java.net.InetSocketAddress;

/**
 * @author 76500
 * 封装端口：在inetaddress基础上+端口
 */
public class inetSocketDemo01 {
	public static void main(String[] args) {
		InetSocketAddress add=new InetSocketAddress("100.67.66.11", 9999);
		System.out.println(add.getHostName());
		System.out.println(add.getPort());
	}
}
