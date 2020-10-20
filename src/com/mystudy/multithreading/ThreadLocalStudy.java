package com.mystudy.multithreading;

/*
 * 多线程是Java实现多任务的基础，Thread对象代表一个线程，我们可以在代码中调用Thread.currentThread()获取当前线程。
 * 
 * Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象。
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
            // 可任意调用UserContext.currentUser():
            String currentUser = UserContext.currentUser();
            
            System.out.println(currentUser);
        } // 在此自动调用UserContext.close()方法释放ThreadLocal关联对象
	}
	
	static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
	
	//这种在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。
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