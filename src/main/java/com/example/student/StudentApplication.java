package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {
    public static void main ( String[] args){
        SpringApplication.run(StudentApplication.class, args);

    }
    public class Student {
        private int id;
        private String name;
        private String email;
        public Student(int id, String name, String email ) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        public int getId( ) {
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public String getEmail(){
            return this.email;
        }
        public void  setId(int id ) {
            this.id = id;
        }
        public void setName( String name){
            this.name = name ;
        }
        public void  setEmail( String email){
            this.email = email;
        }
    }

}
