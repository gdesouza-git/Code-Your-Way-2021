package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String saida1 = "░";
        String nivel1 = "▒";
        String nivel2 = "▓";
        String nivel3 = "█";

        String[][] grade = new String[10][20];

        for (int i = 0; i < grade.length; i++) {
            Arrays.fill(grade[i], saida1);
        }

        //ENTRADA:
        String ent = s.nextLine();
        ent = ent.replace(",","");
        String[] partes = ent.split(" ");
        for (int i = 0; i < partes.length; i+=3) {
            if(i<partes.length) {
                if (Integer.parseInt(partes[i + 2]) == 1)
                    grade[Integer.parseInt(partes[i + 1])][Integer.parseInt(partes[i])] = nivel1;
                else if (Integer.parseInt(partes[i + 2]) == 2)
                    grade[Integer.parseInt(partes[i + 1])][Integer.parseInt(partes[i])] = nivel2;
                else if (Integer.parseInt(partes[i + 2]) == 3)
                    grade[Integer.parseInt(partes[i + 1])][Integer.parseInt(partes[i])] = nivel3;
            }
        }

        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                System.out.print(grade[i][j]);
            }
            System.out.println();
        }
    }
}
