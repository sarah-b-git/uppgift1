package textMorse;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {
    private HashMap<String, String> map;
    private String output = "";
    private String error = "Unrecognized input!";
    private String errorNoMorse = "You can't enter morse code here.";
    private String errorNoEnglish = "You can only enter morse code here.";

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
        map.put("1", "*----");
        map.put("*----", "1");
        map.put("2", "**---");
        map.put("**---", "2");
        map.put("3", "***--");
        map.put("***--", "3");
        map.put("4", "****-");
        map.put("****-", "4");
        map.put("5", "*****");
        map.put("*****", "5");
        map.put("6", "-****");
        map.put("-****", "6");
        map.put("7", "--***");
        map.put("--***", "7");
        map.put("8", "---**");
        map.put("---**", "8");
        map.put("9", "----*");
        map.put("----*", "9");
        map.put("0", "-----");
        map.put("-----", "0");
        map.put(".", "*-*-*-");
        map.put("*-*-*-", ".");
        map.put(",", "--**--");
        map.put("--**--", ",");
        map.put("?", "**--**");
        map.put("**--**", "?");
    }

    //One method for all conversions is too clunky, split into two methods instead
    public String findMatch(String input) {
        input = input.toLowerCase();
        String[] inputArray;
        //If input contains letters, numbers
        //Use regex - doesn't work with any punctuation in regex, why? ---- need special notation for period
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

   public String getMorse(String input){
        output = "";
        input = input.toLowerCase();
        Pattern pattern = Pattern.compile("[*-]");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println(errorNoMorse);
            return errorNoMorse;

        }

       for (int i = 0; i < input.length(); i++) {
           if (map.get(String.valueOf(input.charAt(i))) != null) {
               output += map.get(String.valueOf(input.charAt(i))) + " ";
           } else {
               System.out.println(error);
               return error;
           }
       }
       System.out.println(output);
       return output;
    }

    public String getEnglish(String input){
        output = "";
        Pattern pattern = Pattern.compile("[a-zA-z0-9?.,]");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println(errorNoEnglish);
            return errorNoEnglish;
        }

        String[] inputArray;
        inputArray = input.split(" ");
        for(int i = 0; i < inputArray.length; i++){
            if(map.get(inputArray[i]) != null){
                output += map.get(inputArray[i]);
            }else {
                System.out.println(error);
                return error;
            }
        }
        System.out.println(output);
        return output;

    }



}
