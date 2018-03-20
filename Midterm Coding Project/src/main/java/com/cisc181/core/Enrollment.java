package com.cisc181.core;

import java.util.UUID;

public class Enrollment 
{
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	
	private Enrollment()
	{
	}
	
	public Enrollment(UUID Student, UUID Section)
	{
		StudentID = Student;
		SectionID = Section;
		EnrollmentID = new UUID(3,8);
	}
	
	public void setGrade(double g)
	{
		Grade = g;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	public double getGrade() {
		return Grade;
	}
	
	
}


