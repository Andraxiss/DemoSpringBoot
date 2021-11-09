package com.amigosCode.springBootTutorial.Service;

import com.amigosCode.springBootTutorial.Model.Student;
import com.amigosCode.springBootTutorial.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        } else {
            this.studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (exists){
            this.studentRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Student does not exist");
        }
    }
}
