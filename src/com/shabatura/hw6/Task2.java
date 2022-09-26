package com.shabatura.hw6;

// Ошибка в 24 строке, стояла i вместо j. Изначально просто запустила и мне показала ошибку Index out of bounce в 25,
// дальше поставила breakpoint на 22 строку (начало цикла в котором ошибка) и проверила через степовер последующие строки.
// таким образом выяснила что что-то идет не по плану в 23.
public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}


