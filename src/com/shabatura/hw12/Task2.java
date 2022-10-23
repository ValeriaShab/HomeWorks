package com.shabatura.hw12;

public class Task2 {
    public static void f(){
        try {
            g();
        } catch (Task1.MyOwnException exception){
            try {
                throw new Task1.MyOwnException("f() exception");
            } catch (Task1.MyOwnException exception1){
                exception1.printStackTrace ( System.err );
            }
        }

    }

    public static void g() throws Task1.MyOwnException {
        throw new Task1.MyOwnException("g() exception");
    }

    public static void main(String[] args) {
       f();
    }
}
