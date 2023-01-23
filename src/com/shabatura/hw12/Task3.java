package com.shabatura.hw12;

public class Task3 {
    static class Exception1 extends Exception{
        public Exception1(String message){
            super(message);
        }
    }
    static class Exception2 extends Exception{
        public Exception2(String message){
            super(message);
        }
    }
    static class Exception3 extends Exception{
        public Exception3(String message){
            super(message);
        }
    }

    static class Thrower{
        void methodThrower(int number) throws Exception1, Exception2, Exception3{
            if(number == 1){
                throw new Exception1("Ошибка номер 1");
            }
            if(number == 2){
                throw new Exception2("Ошибка номер 2");
            }
            if(number == 3){
                throw new Exception3("Ошибка номер 3");
            }
        }
    }

    public static void main(String[] args) {
        int number = (int) (Math.random()*3);
        Thrower thrower = new Thrower();
        try{
            thrower.methodThrower(number);
        } catch (Exception1 | Exception2 | Exception3 exception){
            exception.printStackTrace();
        }
    }
}
