import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String entrada;
        entrada = s.nextLine();
        String[] partes = entrada.split(" ");

        String[] cr = new String[Integer.parseInt(partes[2])];

        Arrays.fill(cr, "");

        int j = 0;

        if(Integer.parseInt(partes[2]) != 1) {

            for (int i = 0; i < partes[0].length(); i++) {

                if (j == Integer.parseInt(partes[2])) {
                    j--;
                    while (j > 0) {
                        j--;
                        if (i < partes[0].length()) cr[j] = cr[j] + partes[0].charAt(i);
                        i++;
                    }
                    i--;
                    j++;
                } else {
                    cr[j] = cr[j] + partes[0].charAt(i);
                    j++;
                }
            }

            String cripto = "";
            for (int i = 0; i < Integer.parseInt(partes[2]); i++) {
                cripto = cripto + cr[i];
            }

            System.out.println(cripto);
        } else {
            System.out.println(partes[0]);
        }

    }


}
