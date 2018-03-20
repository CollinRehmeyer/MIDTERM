package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException 
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course(new UUID(1,4), "MATH241", 2);
		Course course2 = new Course(new UUID(1,4), "CISC108", 3);
		Course course3 = new Course(new UUID(1,4), "ANTH251", 2);
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		Semester fall = new Semester(new UUID(1,4), new Date(2017, 8, 21), new Date(2017, 12, 16));
		Semester spring = new Semester(new UUID(1,4), new Date(2018, 2, 3), new Date(2018, 5, 25));
		semesters.add(fall);
		semesters.add(spring);
		
		ArrayList<Section> sections = new ArrayList<Section>();
		
		for(Semester s : semesters)
		{
			for(Course c : courses)
			{
				sections.add(new Section(c.getCourseID(), s.getSemesterID(), new UUID(1,4), new UUID(1,4)));
			}
		}
		
		
		ArrayList<Student> students = new ArrayList<Student>();
		for(int i = 0; i < 10; i++)
		{
			students.add(new Student("Student" + i, "Test", "Test", new Date(1998, 10, 18), eMajor.COMPSCI,"Test", "555-555-5555", "Test"));
		}
		
		
		for(Student g : students)
		{
			for(Section s : sections)
			{
				enrollments.add(new Enrollment(g.getStudentID(), s.getSectionID()));
			}
		}
		
		for(Enrollment e : enrollments)
		{
			e.setGrade(90);
		}
	}

	@Test
	public void test() 
	{
		
		int[] avgs = new int[10]; // avgs[0] corresponds to student1, avgs[2] corresponds to student2, etc
		
		/*
		int Student1Avg = 0;
		int Student2Avg = 0;
		int Student3Avg = 0;
		int Student4Avg = 0;
		int Student5Avg = 0;
		int Student6Avg = 0;
		int Student7Avg = 0;
		int Student8Avg = 0;
		int Student9Avg = 0;
		int Student10Avg = 0;
		*/
		
		for(int i = 0; i < enrollments.size(); i++)
		{
			if(i >= 0 && i <= 5)
				avgs[0] += enrollments.get(i).getGrade();
			
			if(i >= 6 && i <= 11)
				avgs[1] += enrollments.get(i).getGrade();
			
			if(i >= 12 && i <= 17)
				avgs[2] += enrollments.get(i).getGrade();
			
			if(i >= 18 && i <= 23)
				avgs[3] += enrollments.get(i).getGrade();
			
			if(i >= 24 && i <= 29)
				avgs[4] += enrollments.get(i).getGrade();
			
			if(i >= 30 && i <= 35)
				avgs[5] += enrollments.get(i).getGrade();
			
			if(i >= 36 && i <= 41)
				avgs[6] += enrollments.get(i).getGrade();
			
			if(i >= 42 && i <= 47)
				avgs[7] += enrollments.get(i).getGrade();
			
			if(i >= 48 && i <= 53)
				avgs[8] += enrollments.get(i).getGrade();
			
			if(i >= 54 && i <= 59)
				avgs[9] += enrollments.get(i).getGrade();
		}
		
		for(int i = 0; i < avgs.length; i++)
		{
			avgs[i] /= 6;
		}
		
		double[] gpas = new double[10];
		
		for(int i = 0; i < avgs.length; i++)
		{
			gpas[i] = ((double)avgs[i] / 100) * 4;
		}
		
		for(int i = 0; i < avgs.length; i++)
		{
			assertEquals(avgs[i], 90);
		}
		
		for(int i = 0; i < gpas.length; i++)
		{
			assertEquals(gpas[i], 3.6, 0.1);
		}
		
		
	}
}