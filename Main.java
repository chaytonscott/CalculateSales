import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Double> sales = new ArrayList<Double>();

    String inputString = "";

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    void start() {
        System.out.println("Please enter sales, when finished please type x to finish.");

        while (!inputString.equals("x")) {
            getInput();
        }

        exit();
    }

    void getInput() {
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        inputString = input.nextLine();

        if (input.equals("x")) {
            //TODO: CALCULATIONS
        } else {
            if (isInteger(inputString)) {
                Double saleValue = Double.parseDouble(inputString);
                sales.add(saleValue);
            }
        }
    }

    boolean isInteger(String input) {
        boolean isInteger = true;
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            if (!input.equals("x")) {
                System.out.println("Invalid Entry, please try again!");
            }
            isInteger = false;
        }
        return isInteger;
    }

    double getLowestSale() {
        double memory = 9999;
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i) < memory) {
                memory = sales.get(i);
            }
        }
        return memory;
    }

    double getHighestSale() {
        double memory = -1;
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i) > memory) {
                memory = sales.get(i);
            }
        }
        return memory;
    }

    void exit() {
        double average, lowestSale, highestSale;
        double total = 0;

        for (int i = 0; i < sales.size(); i++) {
            total += sales.get(i);
        }

        average = total / sales.size();
        lowestSale = getLowestSale();
        highestSale = getHighestSale();
        System.out.printf("Total sales: \t\t\t%8.2f\n", total);
        System.out.printf("Calculated average: \t%8.2f\n", average);
        System.out.printf("Lowest Sale: \t\t\t%8.2f\n", lowestSale);
        System.out.printf("Highest Sale: \t\t\t%8.2f", highestSale);
    }
}
