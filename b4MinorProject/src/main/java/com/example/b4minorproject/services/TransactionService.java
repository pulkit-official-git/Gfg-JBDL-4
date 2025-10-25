package com.example.b4minorproject.services;

import com.example.b4minorproject.models.*;
import com.example.b4minorproject.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${bookPerStudent}")
    Integer bookPerStudent;


    public String initiate(Integer bookId, Integer studentId, TransactionType txnType) throws Exception {

        switch (txnType){
            case ISSUANCE :
                return this.initiateIssuance(bookId,studentId);
            case RETURN:
                return this.initiateReturn(bookId,studentId);
            default:
                throw new Exception("Invalid txn Type");
        }
    }


    /*
    * Issuance Logic
    * 1. Data Retrieval
    *   1. book
    *   2. student
    * 2. Validations
    *   1.book or student does not exist
    *   2.book is alloted to someone else
    *   3.if limit of allotment exceeds
    * 3. Create a transaction with status as pending
    * 4. Assign book to the student
    * 5. make transaction status as success
    * 6. if it fails make status as failed and handle accordingly
    *
    * */
    private String initiateIssuance(Integer bookId, Integer studentId) throws Exception {

//        ###### Data Retrieval #####

        Book book = this.bookService.getBook(bookId);
        Student student = this.studentService.get(studentId).getStudent();

//        ###### Validations #####

        if(student == null || student.getStatus()== StudentStatus.INACTIVE){
            throw new Exception("invalid student Id");
        }

        if(book == null || book.getStudent()!=null){
            throw new Exception("book is not available for issuance");
        }

        List<Book> issuedBooks = student.getBooks();
        if(issuedBooks != null && issuedBooks.size() > this.bookPerStudent ){
            throw new Exception("student book limit exceeded");
        }

        Transaction transaction = Transaction
                .builder()
                .book(book)
                .student(student)
                .txnId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .transactionType(TransactionType.ISSUANCE)
                .build();

        Transaction savedTransaction = this.transactionRepository.save(transaction);

        try {
            book.setStudent(student);
            this.bookService.save(book);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            savedTransaction=this.transactionRepository.save(transaction);
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            savedTransaction=this.transactionRepository.save(transaction);
            if(book.getStudent()!=null){
                book.setStudent(null);
                this.bookService.save(book);
            }
        }
        return transaction.getTxnId();



    }

    private String initiateReturn(Integer bookId, Integer studentId) throws Exception {

        //        ###### Data Retrieval #####

        Book book = this.bookService.getBook(bookId);
        Student student = this.studentService.get(studentId).getStudent();

        //        ###### Validations #####

        if(student == null){
            throw new Exception("invalid student Id");
        }

        if(book == null || book.getStudent()==null || book.getStudent().getId()!=studentId){
            throw new Exception("book cannot be returned");
        }

        Transaction transaction = Transaction
                .builder()
                .book(book)
                .student(student)
                .txnId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .transactionType(TransactionType.RETURN)
                .build();

        Transaction savedTransaction = this.transactionRepository.save(transaction);

//        try{
//            Integer fine = getFine(student,book);
//        }
        return "hello";

    }

    private Integer getFine(Student student, Book book) {
//        Transaction issuedTxn = this.transactionRepository.findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc
//                (book,student,TransactionType.ISSUANCE,TransactionStatus.SUCCESS);
//
//        Long issuedTimeInMillis = issuedTxn.getUpdatedOn().getTime();
//        Long totalTimeDiffInMillis = System.currentTimeMillis()-issuedTimeInMillis;
//
//        Long days = TimeUnit.MILLISECONDS.toDays(totalTimeDiffInMillis);
        return 0;
    }
}
