package com.mystudy.serialize;

public class Employee implements java.io.Serializable 
{
	/**
	 * default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public String name;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck()
	{
		System.out.println("Mailing a check to " + name + " " + address);
	}
}