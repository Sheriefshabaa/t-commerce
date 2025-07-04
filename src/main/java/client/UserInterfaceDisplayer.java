package client;

import pojos.Customer;

public class UserInterfaceDisplayer {
    public static void customerInfo(Customer c) {
        System.out.printf("%-24s%-24s\n", "Customer Name", "Balance");
        System.out.printf("%-24s%-24s\n", c.getName(), c.getBalance());
    }

    public static void printHeader(String header) {
        System.out.printf("\t%s\n", header);
    }
}
