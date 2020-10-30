package com.mystudy.net;

import java.net.URI;
import java.net.URISyntaxException;

public class URLStudy01
{
	public static void main(String[] args)
	{
		try {
			URI url = new URI("http://www.runoob.com/index.html?language=cn#j2se");
			System.out.println("URL Ϊ��" + url.toString());
			System.out.println("Authority��" + url.getAuthority());
			System.out.println("Fragment��" + url.getFragment());
			System.out.println("Host��" + url.getHost());
			System.out.println("Path��" + url.getPath());
			System.out.println("Port��" + url.getPort());
			System.out.println("Query��" + url.getQuery());
			System.out.println("RawAuthority��" + url.getRawAuthority());
			System.out.println("RawFragment��" + url.getRawFragment());
			System.out.println("RawPath��" + url.getRawPath());
			System.out.println("RawQuery��" + url.getRawQuery());
			System.out.println("RawSchemeSpecificPart��" + url.getRawSchemeSpecificPart());
			System.out.println("RawUserInfo��" + url.getRawUserInfo());
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
}
