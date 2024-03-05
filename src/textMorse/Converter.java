package textMorse;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    private HashMap<String, String> map;
    private String output = "";
    private String error = "Unrecognized input!";

    public Converter() {
        map = new HashMap<>();
        map.put("a", "*-");
        map.put("*-", "a");
        map.put("b", "-***");
        map.put("-***", "b");
        map.put("c", "-*-*");
        map.put("-*-*", "c");
        map.put("d", "-**");
        map.put("-**", "d");
        map.put("e", "*");
        map.put("*", "e");
        map.put("f", "**-*");
        map.put("**-*", "f");
        map.put("g", "--*");
        map.put("--*", "g");
        map.put("h", "****");
        map.put("****", "h");
        map.put("i", "**");
        map.put("**", "i");
        map.put("j", "*---");
        map.put("*---", "j");
        map.put("k", "-*-");
        map.put("-*-", "k");
        map.put("l", "*-**");
        map.put("*-**", "l");
        map.put("m", "--");
        map.put("--", "m");
        map.put("n", "-*");
        map.put("-*", "n");
        map.put("o", "---");
        map.put("---", "o");
        map.put("p", "*--*");
        map.put("*--*", "p");
        map.put("q", "--*-");
        map.put("--*-", "q");
        map.put("r", "*-*");
        map.put("*-*", "r");
        map.put("s", "***");
        map.put("***", "s");
        map.put("t", "-");
        map.put("-", "t");
        map.put("u", "**-");
        map.put("**-", "u");
        map.put("v", "***-");
        map.put("***-", "v");
        map.put("w", "*--");
        map.put("*--", "w");
        map.put("x", "-**-");
        map.put("-**-", "x");
        map.put("y", "-*--");
        map.put("-*--", "y");
        map.put("z", "--**");
        map.put("--**", "z");
    }

    public String findMatch(String input) {
        input = input.toLowerCase();
        String[] inputArray;
        //If input contains letters, numbers
        //Use regex - doesn't work with any punctuation in regex, why?
        //REFACTOR - save each letter in an array, use split("") or charAt()
        Pattern pattern = Pattern.compile("[a-z]|[0-9]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            for (int i = 0; i < input.length(); i++) {
                if (map.get(String.valueOf(input.charAt(i))) != null) {
                    output += map.get(String.valueOf(input.charAt(i))) + " ";
                } else {
                    return error;
                }
            }
            return output;
            //ELSE = INPUT CONTAINS MORSE, SPLIT STRING THEN FOLLOW MATCH PROCEDURE W/ARRAY
        } else {
            inputArray = input.split(" ");
            for(int i = 0; i < inputArray.length; i++){
                if(map.get(inputArray[i]) != null){
                    output += map.get(inputArray[i]);
                }else {
                    return error;
                }
            }
            return output;
        }
    }



}
