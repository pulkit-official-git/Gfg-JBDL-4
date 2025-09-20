package Exceptions;

import java.sql.SQLException;

public class Student {

    public int findStudentByRollNumber(int rollNumber) throws ClassNotFoundException, OddException, SQLException {

            if (rollNumber < 50) {
                throw new ClassNotFoundException();
            } else if (rollNumber % 2 == 0) {
                throw new EvenException();
            } else if (rollNumber % 2 == 1) {
                throw new OddException();
            }else{
                throw new SQLException();
            }


//        return 1/0; //Run time Exception/Unchecked Exception
    }
}
