package pojos;

/**
     * Represents a customer with a name and a balance.
     */
    public class Customer {
        private String name; // The name of the customer
        private Double balance; // The balance of the customer

        /**
         * Constructs a Customer with the specified balance.
         *
         * @param balance The initial balance of the customer.
         */
        public Customer(Double balance) {
            this.balance = balance;
        }

        /**
         * Constructs a Customer with the specified name and balance.
         *
         * @param name    The name of the customer.
         * @param balance The initial balance of the customer.
         */
        public Customer(String name, Double balance) {
            this.name = name;
            this.balance = balance;
        }

        /**
         * Gets the name of the customer.
         *
         * @return The name of the customer.
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the customer.
         *
         * @param name The new name of the customer.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the balance of the customer.
         *
         * @return The balance of the customer.
         */
        public Double getBalance() {
            return balance;
        }

        /**
         * Updates the balance of the customer by adding the specified amount.
         *
         * @param balance The amount to add to the customer's balance.
         */
        public void setBalance(Double balance) {
            this.balance += balance;
        }
    }
