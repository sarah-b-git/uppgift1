package textMorse;

import java.util.Scanner;

public class ConverterDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Converter convert = new Converter();

        boolean runProgram = true;

        while(runProgram){
            System.out.println("Choose from the menu:\n1. Convert english to " +
                    "morse code\n2. Convert morse code to english" +
                    "\n3. End program");
            try {
                int input = Integer.parseInt(scan.nextLine());

                switch (input) {
                    case 1:
                        System.out.println("Enter english text, do not include morse code:");
                        String engText = scan.nextLine();
                        convert.getMorse(engText);
                        break;
                    case 2:
                        System.out.println("Enter morse code, use spaces to separate letters:");
                        String morseText = scan.nextLine();
                        convert.getEnglish(morseText);
                        break;
                    case 3:
                        runProgram = false;
                        break;
                }
            } catch(Exception e){
                System.out.println("Enter only numbers 1-3 without punctuation");
            }
        }



    }

}
