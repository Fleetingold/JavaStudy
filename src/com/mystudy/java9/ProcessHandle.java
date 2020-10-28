package com.mystudy.java9;

import java.time.LocalDateTime;
import java.util.Optional;

public class ProcessHandle {

	public static Info info() {
		return new ProcessHandle().new Info();
	}
	
	public class Info {

		public Optional<String> command() {
			// TODO Auto-generated method stub
			return Optional.ofNullable("C:\\Windows\\System32\\notepad.exe");
		}

		public Optional<String> commandLine() {
			// TODO Auto-generated method stub
			return Optional.ofNullable(null);
		}

		public Optional<LocalDateTime> startInstant() {
			// TODO Auto-generated method stub
			return Optional.of(LocalDateTime.of(2017, 11, 4, 21, 35, 03, 626));
		}

		public Optional<String[]> arguments() {
			// TODO Auto-generated method stub
			return Optional.ofNullable(null);
		}

		public Optional<String> user() {
			// TODO Auto-generated method stub
			return Optional.of("administrator");
		}

	}

}
