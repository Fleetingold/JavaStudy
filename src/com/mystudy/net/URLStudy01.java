package com.mystudy.net;

import java.net.URI;
import java.net.URISyntaxException;

public class URLStudy01
{
	public static void main(String[] args)
	{
		try {
			URI url = new URI("http://www.runoob.com/index.html?language=cn#j2se");
			System.out.println("URL Îª£º" + url.toString());
			System.out.println("Authority£º" + url.getAuthority());
			System.out.println("Fragment£º" + url.getFragment());
			System.out.println("Host£º" + url.getHost());
			System.out.println("Path£º" + url.getPath());
			System.out.println("Port£º" + url.getPort());
			System.out.println("Query£º" + url.getQuery());
			System.out.println("RawAuthority£º" + url.getRawAuthority());
			System.out.println("RawFragment£º" + url.getRawFragment());
			System.out.println("RawPath£º" + url.getRawPath());
			System.out.println("RawQuery£º" + url.getRawQuery());
			System.out.println("RawSchemeSpecificPart£º" + url.getRawSchemeSpecificPart());
			System.out.println("RawUserInfo£º" + url.getRawUserInfo());
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
}
