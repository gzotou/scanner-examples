import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            //for-each loop
            for (double currentResult : results) {
                System.out.println(currentResult);
            }
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if (args.length == 3) {
            handleCommandLine(args);
        } else {
            System.out.println("Please provide an operation code and two values");
        }

    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble((args[1]));
        double rightVal = Double.parseDouble((args[2]));
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static void executeInteractively() {
        System.out.println("Please type an operation code and two values");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperations(parts);
    }

    private static void performOperations(String[] parts) {
        char opCode = opCodesFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    private static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        String strOpCode = String.valueOf(opCode);
        switch (strOpCode) {
            case "a":
                result = leftVal + rightVal;
                break;
            case "s":
                result = leftVal - rightVal;
                break;
            case "m":
                result = leftVal * rightVal;
                break;
            case "d":
                result = leftVal / rightVal;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    private static char opCodesFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    private static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for (int i = 0; i < numberWords.length; i++) {
            if (word.equals(numberWords[i])) {
                value = i;
                break;
            }
        }
        return value;
    }
}

