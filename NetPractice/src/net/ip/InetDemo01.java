package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		//����getlocalhost����inetaddress����
		InetAddress add1=InetAddress.getLocalHost();
		System.out.println(add1.getHostAddress()); //host��ַ
		System.out.println(add1.getHostName());  //�������
		//���������õ�inetaddress����
		add1=InetAddress.getByName("www.163.com");
		System.out.println(add1.getHostAddress()); //����163��������ip
		System.out.println(add1.getHostName()); //���www.163.com
		
		//����ip
		add1=InetAddress.getByName("203.130.59.30");
		System.out.println(add1.getHostAddress());
		System.out.println(add1.getHostName());
	}
}
