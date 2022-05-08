package com.saveforgreen.datastructures.problem;

// java.lang.StringBuffer.delete()
import java.lang.*;

public class Test {

	public static void main(String[] args)
	{

		StringBuffer sbf = new StringBuffer("101");
		System.out.println("string buffer = " + sbf);

		sbf.delete(sbf.length()-1, sbf.length());
		System.out.println("After deletion string buffer is = " + sbf);
	}
}
