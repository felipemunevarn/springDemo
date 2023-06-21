package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service    
public class StudentService {

    	public List<Student> getStudents() {
		return List.of(
			new Student(
				1L,
				"Mary",
				"maanraca@gmail.com",
				LocalDate.of(1982,Month.JANUARY,23),
				33
			)
		);
	}

}