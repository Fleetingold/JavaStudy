package com.mystudy.multithreading;

/*
 * ���߳���Javaʵ�ֶ�����Ļ�����Thread�������һ���̣߳����ǿ����ڴ����е���Thread.currentThread()��ȡ��ǰ�̡߳�
 * 
 * Java��׼���ṩ��һ�������ThreadLocal����������һ���߳��д���ͬһ������
 */
public class ThreadLocalStudy {

	public static void main(String[] args) {
		log("start main...");
        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");
        
        try (UserContext ctx = new UserContext("Bob")) {
            // ���������UserContext.currentUser():
            String currentUser = UserContext.currentUser();
            
            System.out.println(currentUser);
        } // �ڴ��Զ�����UserContext.close()�����ͷ�ThreadLocal��������
	}
	
	static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
	
	//������һ���߳��У�������ɷ������ã���Ҫ���ݵĶ�������ͨ����֮Ϊ�����ģ�Context��������һ��״̬���������û���ݡ�������Ϣ�ȡ�
	//	public void process(User user) {
	//	    checkPermission();
	//	    doWork();
	//	    saveStatus();
	//	    sendResponse();
	//	}
}

class UserContext implements AutoCloseable {

    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() {
        ctx.remove();
    }
}