package com.example.batch4iocdi.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = "prototype")
public class DemoRepository {
    int a;
}
