import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stock prices
        Map<String, Double> prices = new HashMap<>();
        prices.put("TCS", 3200.0);
        prices.put("INFY", 1450.0);
        prices.put("HDFC", 1650.0);

        // User portfolio and balance
        Map<String, Integer> portfolio = new HashMap<>();
        double balance = 10000;

        while (true) {
            System.out.println("\n===== Stock Trading Menu =====");
            System.out.println("1. View Stock Prices");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\n--- Stock Prices ---");
                for (String stock : prices.keySet()) {
                    System.out.println(stock + ": ₹" + prices.get(stock));
                }

            } else if (choice == 2) {
                System.out.print("Enter stock name (TCS, INFY, HDFC): ");
                String stock = sc.next().toUpperCase();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                if (prices.containsKey(stock)) {
                    double cost = prices.get(stock) * qty;
                    if (balance >= cost) {
                        balance -= cost;
                        portfolio.put(stock, portfolio.getOrDefault(stock, 0) + qty);
                        System.out.println(" Bought " + qty + " shares of " + stock);
                    } else {
                        System.out.println(" Not enough balance.");
                    }
                } else {
                    System.out.println(" Stock not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter stock name to sell: ");
                String stock = sc.next().toUpperCase();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                int owned = portfolio.getOrDefault(stock, 0);
                if (owned >= qty) {
                    balance += prices.get(stock) * qty;
                    portfolio.put(stock, owned - qty);
                    System.out.println(" Sold " + qty + " shares of " + stock);
                } else {
                    System.out.println(" You don’t own enough shares.");
                }

            } else if (choice == 4) {
                System.out.println("\n--- Your Portfolio ---");
                for (String s : portfolio.keySet()) {
                    int qty = portfolio.get(s);
                    double value = prices.get(s) * qty;
                    System.out.println(s + ": " + qty + " shares → ₹" + value);
                }
                System.out.println(" Balance: ₹" + balance);

            } else if (choice == 5) {
                System.out.println(" Exiting. Thank you!");
                break;

            } else {
                System.out.println(" Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}

