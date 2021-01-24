package com.chstore.ca.employee.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public interface MyServiceInterface {
    void myMethod();
}

@Service
@Primary
class MyServiceA implements MyServiceInterface {
    @Override
    public void myMethod() {
        System.out.print("Do A");
    }
}


@Service
class MyServiceB implements MyServiceInterface {
    @Override
    public void myMethod() {
        System.out.print("Do B");
    }
}

@Service
class MyBusinessLogic {

    @Autowired
    private MyServiceInterface myServiceInterface;

    public void businessLogic() {
        System.out.println("Do something");
        myServiceInterface.myMethod();
        System.out.println("Done");
    }
}