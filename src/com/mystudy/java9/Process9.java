package com.mystudy.java9;

import java.io.InputStream;
import java.io.OutputStream;

import com.mystudy.java9.ProcessHandle.Info;

public class Process9 extends Process {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int exitValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InputStream getErrorStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int waitFor() throws InterruptedException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Info info() {
		// TODO Auto-generated method stub
		return ProcessHandle.info();
	}

	public int pid() {
		// TODO Auto-generated method stub
		return 5800;
	}

}
