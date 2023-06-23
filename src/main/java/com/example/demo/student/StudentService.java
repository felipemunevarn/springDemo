package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service    
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
    public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = 
			studentRepository.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()){
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		if (!studentRepository.existsById(id)){
			throw new IllegalStateException(
				"student with id " + id + " does not exist");
		}
		studentRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent(Long id, Student student) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if (!studentOptional.isPresent()){
			throw new IllegalStateException("student with id " + id + " does not exist");
		}
		studentOptional.get().setName(student.getName());
		studentOptional.get().setEmail(student.getEmail());
		studentRepository.save(studentOptional.get());
	}

}