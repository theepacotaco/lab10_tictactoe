import java.util.Scanner;
public class safeinput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print('\n' + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int resultInt = 0;
        boolean gotAValue = false;
        String trash = "";
        do {
            System.out.println('\n' + prompt + ": ");
            if(pipe.hasNextInt()){
                resultInt = pipe.nextInt();
                pipe.nextLine();
                gotAValue = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("\nInvalid input try again");
            }
        }while(!gotAValue);
        return resultInt;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double resultDouble = 0;
        boolean gotAValue = false;
        String trash = "";
        do {
            System.out.println('\n' + prompt + ": ");
            if(pipe.hasNextDouble()){
                resultDouble = pipe.nextDouble();
                pipe.nextLine();
                gotAValue = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("\nInvalid input try again");
            }
        }while(!gotAValue);
        return resultDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int resultRangedInt = 0;
        boolean gotAValue = false;
        String trash = "";
        do {
            System.out.println('\n' + prompt + ": ");
            if(pipe.hasNextInt()){
                resultRangedInt = pipe.nextInt();
                pipe.nextLine();
                if (resultRangedInt >= low && resultRangedInt <= high){
                    gotAValue = true;
                }else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + resultRangedInt);
                }

            }else{
                trash = pipe.nextLine();
                System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + resultRangedInt);
            }
        }while(!gotAValue);
        return resultRangedInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double resultRangedDouble = 0;
        boolean gotAValue = false;
        String trash = "";
        do {
            System.out.println('\n' + prompt + ": ");
            if(pipe.hasNextDouble()){
                resultRangedDouble = pipe.nextDouble();
                pipe.nextLine();
                if (resultRangedDouble >= low && resultRangedDouble <= high){
                    gotAValue = true;
                }else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + resultRangedDouble);
                }

            }else{
                trash = pipe.nextLine();
                System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + resultRangedDouble);
            }
        }while(!gotAValue);
        return resultRangedDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        String retYN = "";
        do {
            System.out.println('\n' + prompt + ": ");
        }while(!pipe.hasNext() && !pipe.next().equals("Y") && !pipe.next().equals("y") && !pipe.next().equals("N")&& !pipe.next().equals("n"));
        retYN = pipe.next();
        if (retYN.equalsIgnoreCase("Y")){
            return true;
        }else{
            return false;
        }

    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String value = "";
        boolean gotAValue = false;

        do{
            System.out.println('\n' + prompt + ": ");
            value = pipe.nextLine();
            if(value.matches(regEx)){
                gotAValue = true;

            }else{
                System.out.println("\nInvalid input: " + value);
            }
        }while(!gotAValue);
        return value;
    }

    public static Boolean prettyHeader(Scanner pipe, String prompt) {
        int headerWidth = 60;
        String userInput;
        boolean isValid = false;

        do {
            System.out.print("\n"+ prompt + ": ");
            String trash = "";
            userInput = pipe.nextLine().trim();
            //userInput.matches("^[a-zA-Z\\s]*$") &&
            if (userInput.length() <= 54) {
                isValid = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Invalid input. Please enter a valid message (54 characters or fewer).");
            }
        } while (!isValid);

        int messageWidth = userInput.length();
        int leftPadding = (headerWidth - messageWidth - 6) / 2;
        int rightPadding = headerWidth - messageWidth - 6 - leftPadding;

        System.out.println();
        for (int i = 0; i < headerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        for(int i = 0; i < 3; i++){
            System.out.print("*");
        }
        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }
        System.out.print(userInput);
        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }
        for(int i = 0; i < 3; i++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < headerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
        return(isValid);
    }


}

