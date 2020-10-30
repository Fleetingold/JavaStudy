package com.mystudy.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaNashornStudy01 {
	public static void main(String[] args) {
		
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		
		String name = "Runoob";
		Integer result = null;
		
		try 
		{
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		} 
		catch (ScriptException e) 
		{
			System.out.println("Ö´ÐÐ½Å±¾´íÎó: " + e.getMessage());
		}
		
		System.out.println(result.toString());
	}
}
