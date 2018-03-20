package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	private static ArrayList<Staff> staf = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() 
	{
		
		double initSalary = 10;
		for(int i = 0; i < 5; i++)
		{
			Staff s = new Staff(null);
			s.setSalary(initSalary);
			staf.add(s);
			initSalary += 5;
		}
	}
	
	@Test
	public void test() 
	{
		int avg = 0;
		for(int j = 0; j < staf.size(); j++)
		{
			avg += staf.get(j).getSalary();
		}
		
		avg = avg / staf.size();
		
		assertEquals(avg, 20.0, 0.1);
	}
	
	@Test
	public void test2() throws PersonException
	{
		boolean testo = false;
		
		Staff OLDtest = new Staff("Tester", "Testie", "Testman", new Date(1980, 1, 1), "Test", "555-555-5555", "email", "office", 
				2, 2, new Date(1960, 1, 1), eTitle.MRS);
		try 
		{
			
			OLDtest.setDOB(new Date(1776, 1, 1));
			
		} 
		catch (PersonException e) 
		{
			
			testo = true;
			
		}
		
		assertEquals(testo, true);
	}
	
	@Test
	public void test3() throws PersonException
	{
		boolean tester = false;
		
		Staff PHONEtest = new Staff("Tester", "Testie", "Testman", new Date(1972, 1, 1), "Test", "555-555-5555", "email", "office",
				2, 2, new Date(2000, 1, 1), eTitle.MRS);
		try 
		{
			
			PHONEtest.setPhone("567");
			
		} 
		
		catch (PersonException e) 
		{
			
			tester = true;
			
		}
		
		assertEquals(tester, true);
	}

}
