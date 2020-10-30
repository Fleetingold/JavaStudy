package com.mystudy.java9;

import java.time.ZoneId;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.IOException;

public class ProcessHandleStudy01 {
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("notepad.exe");
		pb.start();
		String np = "Not Present";
		Process9 p = new  Process9();
		ProcessHandle.Info info = p.info();
		System.out.printf("Process ID : %s%n", p.pid());
		System.out.printf("Command name : %s%n", info.command().orElse(np));
	    System.out.printf("Command line : %s%n", info.commandLine().orElse(np));
	    
	    System.out.printf("Start time: %s%n",
            info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
            .toLocalDateTime().toString()).orElse(np));
	    
	    System.out.printf("Arguments : %s%n",
            info.arguments().map(a -> Stream.of(a).collect(
            Collectors.joining(" "))).orElse(np));
	    
	    System.out.printf("User : %s%n", info.user().orElse(np));
	}
}
