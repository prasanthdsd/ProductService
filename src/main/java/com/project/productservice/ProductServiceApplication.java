package com.project.productservice;

import com.project.productservice.inheritancerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    ProductServiceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository, @Qualifier("st_studentrepository") StudentRepository studentRepository, @Qualifier("st_userrepository") UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

//    private MentorRepository mentorRepository;
//
//    private StudentRepository studentRepository;
//
//    private UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Mentor");
//        mentor.setEmail("mentor@gmail.com");
//        mentor.setAverageRating(4.8);
//
//        mentorRepository.save(mentor);

//        //tpc_mentor
//        Mentor mentor = new Mentor();
//        mentor.setName("Tpc_Mentor");
//        mentor.setEmail("tpc_mentor@gmail.com");
//        mentor.setAverageRating(4.5);
//
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Tpc_Student");
//        student.setEmail("tpc_student@gmail.com");
//        student.setPsp(85.2);
//
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setName("Tpc_User");
//        user.setEmail("tpc_user@gmail.com");
//
//        userRepository.save(user);
//
//        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("Jack");
        user.setEmail("jack@gmail.com");
        userRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setName("mentor");
        mentor.setEmail("mentor@gmail.com");
        mentor.setAverageRating(70.2);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("student");
        student.setEmail("student@gmail.com");
        student.setPsp(56);
        studentRepository.save(student);

    }
}
