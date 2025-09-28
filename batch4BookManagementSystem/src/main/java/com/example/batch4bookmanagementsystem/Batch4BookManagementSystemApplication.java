package com.example.batch4bookmanagementsystem;

import com.example.batch4bookmanagementsystem.models.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Batch4BookManagementSystemApplication {

//    public void getName(int a, int b) {
//        System.out.println("getName " + a + " " + b);
//        a+=100;
//        b+=200;
//        System.out.println("getName " + a + " " + b);
//    }

//    public void getName2(final int a, final int b) {
//        System.out.println("getName " + a + " " + b);
//        a+=100;
//        b+=200;
//        System.out.println("getName " + a + " " + b);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Batch4BookManagementSystemApplication.class, args);

//        Book book = new Book();
//        book.setId(1);
//        System.out.println(book.getId());

//        Book book2 = new Book(1,"Intro to Java","BCD", "george",42.80,new Date(),new Date());

//        Book book3 = new Book().setId(2)
//                .setAuthor("John");
//        System.out.println(book3);
//
//        book3.setCreatedOn(new Date());
//        System.out.println(book3);

//        Book.BookBuilder b4 = Book
//                .builder()
//                .id(2)
//                .author("George");
////                .build();
//
//        b4.createdOn(new Date());
//
//        b4.updatedOn(new Date());
//
//        Book b5 = b4.build();
    }

}
