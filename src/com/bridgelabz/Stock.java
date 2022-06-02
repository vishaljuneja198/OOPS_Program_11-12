package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;
class Stock {
    String stockName;
    int noOfShares;
    int sharePrice;

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setNoOfShares(int noOfShares) {
        this.noOfShares = noOfShares;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }
}

class StockPortfolio {
    static ArrayList<Stock> portfolio = new ArrayList<>();
    static int totalValue;

    public static void addStock() {
        Scanner sc = new Scanner(System.in);
        Stock stockInfo = new Stock();

        System.out.println("Enter Stock detail you want to purchase");
        System.out.println("Enter a Name of Sock: ");
        stockInfo.setStockName(sc.next());
        System.out.println("Enter Number of Shares you want to purchase: ");
        stockInfo.setNoOfShares(sc.nextInt());
        System.out.println("Enter Share Price: ");
        stockInfo.setSharePrice(sc.nextInt());

        portfolio.add(stockInfo);
        System.out.println();
        System.out.println("Stock Added");
    }

    public static void addNoOfStock() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number of Stock you want to add");
        int noOfStock = sc.nextInt();
        for (int i = 0; i < noOfStock; i++)  {
            addStock();
        }
    }

    public static void totalValue() {
        for (Stock stock : portfolio) {
            totalValue += stock.sharePrice * stock.noOfShares;
        }
        System.out.println(totalValue);
    }
}

class StockManagement {

    public static void main(String[] args) {

        StockPortfolio stocks = new StockPortfolio();

        int choice = 0;
        while (choice < 4) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" Enter your choice 1: Add Stock 2: Add Multiple of Stocks 3: Display Total value of Stocks 0: Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    stocks.addStock();
                    break;
                case 2:
                    stocks.addNoOfStock();
                    break;
                case 3:
                    System.out.println("Total value of your stocks is : ");
                    stocks.totalValue();
                    break;
                default:
                    choice = 4;
                    break;
            }
        }
    }
}