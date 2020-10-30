package com.mystudy.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread
{
	private ServerSocket serverSocket;
	
	public GreetingServer(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(30000);
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("�ȴ�Զ������,�˿ں�Ϊ: " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Զ��������ַ: " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("лл������: " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
			}
			catch (SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		try {
			Thread t = new GreetingServer(port);
			t.run();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}