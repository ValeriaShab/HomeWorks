package com.shabatura.hw12;

public class Task3 {
    static class Exception1 extends Exception{
    }
    static class Exception2 extends Exception{
    }
    static class Exception3 extends Exception{
    }

    static class Thrower{
        void methodThrower() throws Exception1, Exception2, Exception3{
            try {
                throw new Exception1();
            } catch (Exception1 exception1){
                exception1.printStackTrace();
            }
            try {
                throw new Exception2();
            } catch (Exception2 exception2){
                exception2.printStackTrace();
            }
            try {
                throw new Exception3();
            } catch (Exception3 exception3){
                exception3.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thrower thrower = new Thrower();
        try{
            thrower.methodThrower();
        } catch (Exception1 | Exception2 | Exception3 exception){
            exception.printStackTrace();
        }
    }
}
