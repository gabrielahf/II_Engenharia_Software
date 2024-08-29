/*
Um método que recebe como parâmetro uma String e retorna
uma nova String sem caracteres repetidos da String original. Utilizar um "conjunto".
Ex.: String "Teste", resultado: "Test"
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class Conjunto {
    public static String removeDuplicates(String input) {
        if (input == null) {
            return null;
        }

        Set<Character> conjunto = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            conjunto.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : conjunto) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Teste";
        String output = removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}

