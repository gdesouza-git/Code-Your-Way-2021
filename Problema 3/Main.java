import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> l = new LinkedList<>();
        List<Integer> a = new LinkedList<>();

        String ent = s.nextLine();
        ent = ent.replace(",", "");
        String[] part = ent.split(" ");

        for (int i=0; i<part.length; i++)
            switch (part[i]) {
                case "circle" -> {
                    l.add(Integer.parseInt(part[i + 1]) * 2);
                    a.add(Integer.parseInt(part[i + 1]) * 2);
                }
                case "rectangle" -> {
                    l.add(Integer.parseInt(part[i + 1]));
                    a.add(Integer.parseInt(part[i + 2]));
                }
                case "square" -> {
                    l.add(Integer.parseInt(part[i + 1]));
                    a.add(Integer.parseInt(part[i + 1]));
                }
                default -> LOGGER.log(Level.SEVERE, "entrada invalida");
            }


        Collections.sort(l);
        Collections.sort(a);

        System.out.println(l.get(l.size()-1) +" "+a.get(a.size()-1));
    }
}
