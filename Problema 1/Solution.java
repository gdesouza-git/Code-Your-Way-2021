import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

           
                if (entry1[col] < entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static String compute_ranking(String scores) {
        // Write your code here

        String[] inputs = scores.split(",");
        for (int i = 1; i < inputs.length; i++) {
            inputs[i] = inputs[i].trim();
        }
        ArrayList<String[]> inputs_split = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            String[] buffer_split = new String[inputs[i].split("\\s").length];
            inputs_split.add(inputs[i].split("\\s"));
        }

        Integer[][] results = new Integer[inputs.length][];

        for (int j = 0; j < inputs_split.size(); j++) {
            Integer[] buffer = new Integer[]{0, 0};
            buffer[0] = Integer.parseInt(inputs_split.get(j)[0]);
            for (int k = 1; k < 11; k++) {
                String s = inputs_split.get(j)[k];
                buffer[1] += Integer.parseInt(s);
            }
            results[j] = buffer;
        }

        int[][] results_array = new int[inputs.length][2];

        for (int i = 0; i < results.length; i++) {
            results_array[i][0] = results[i][0];
            results_array[i][1] = results[i][1];
        }

        sortbyColumn(results_array, 0);
        sortbyColumn(results_array, 1);

        if (results.length > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < results.length; i++) {
                if (i == results.length - 1) {
                    stringBuilder.append(results_array[i][0] + " " + results_array[i][1]);
                } else {
                    stringBuilder.append(results_array[i][0] + " " + results_array[i][1] + ", ");
                }
            }
            return stringBuilder.toString();
        }

        return results_array[0][0] + " " + results_array[0][1];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
    
        String scores = "1 1 1 1 1 1 1 1 1 1 1, 2 0 0 0 0 0 0 0 0 0 0, 3 1 1 1 1 1 1 1 1 1 1, 3 1 1 1 1 1 0 0 0 0 0, 2 1 1 1 1 1 1 1 1 1 1";
        String scores2 = "7 1 0 0 0 0 0 0 0 0 0";
        String result = Result.compute_ranking(scores);
        System.out.println(result);
 
    }
}