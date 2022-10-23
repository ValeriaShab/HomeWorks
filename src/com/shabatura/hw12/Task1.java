package com.shabatura.hw12;

public class Task1 {
    static class MyOwnException extends Exception{
        public MyOwnException(String message){
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            throw new MyOwnException("something");
        } catch ( MyOwnException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("something else");
        }
    }
}
