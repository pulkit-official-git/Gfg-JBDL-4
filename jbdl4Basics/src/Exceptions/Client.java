package Exceptions;

import java.sql.SQLException;

public class Client {
    public static void main(String[] args) throws OddException, ClassNotFoundException {
        Student student = new Student();
        try {
            student.findStudentByRollNumber(49);
        }catch ( ClassNotFoundException cnfe){
//            throw new ClassNotFoundException();

        }catch (OddException oe){
//            System.out.println("Tried but cannot resolve");
//            throw new OddException();

        }catch (SQLException sqle){
            /*
            * cron jobs
            * retries 3
            * */

        }finally {
            System.out.println("Success from finally");
        }

        System.out.println("Success from out of finally");



    }
}

//A B C D
//  <-  <-  <-