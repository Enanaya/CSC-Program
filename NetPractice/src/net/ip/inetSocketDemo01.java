package net.ip;

import java.net.InetSocketAddress;

/**
 * @author 76500
 * ��װ�˿ڣ���inetaddress������+�˿�
 */
public class inetSocketDemo01 {
	public static void main(String[] args) {
		InetSocketAddress add=new InetSocketAddress("100.67.66.11", 9999);
		System.out.println(add.getHostName());
		System.out.println(add.getPort());
	}
}
