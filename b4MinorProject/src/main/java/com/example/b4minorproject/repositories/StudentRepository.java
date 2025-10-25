package com.example.b4minorproject.repositories;

import com.example.b4minorproject.models.Student;
import com.example.b4minorproject.models.StudentStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    @Transactional
    @Modifying
    @Query("update Student s set s.status=?2 where s.id = ?1")
    void deactivate(Integer id, StudentStatus studentStatus);
}
