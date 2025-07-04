# Shopping Cart Management System

## Overview
This project is a **Shopping Cart Management System** implemented in Java. It provides functionality for managing a shopping cart, customers, and products. The system includes features such as adding products to a cart, checking out, and handling insufficient funds.

## Features
- **Cart Management**: Manage a shopping cart with products and calculate totals.
- **Customer Management**: Handle customer details and balances.
- **Product Management**: Define and manage products with properties like name, price, quantity, and expiry status.
- **Checkout Process**: Deduct the total cart amount from the customer's balance and handle insufficient funds.

## Project Structure
The project follows a modular structure with the following key components:

### `services.CartService`
- Manages the shopping cart and handles the checkout process.
- Throws `InsufficientFundsException` if the customer's balance is insufficient during checkout.

### `pojos.Product`
- Abstract class representing a generic product.
- Includes properties like name, quantity, price, and expiry status.

### `pojos.Customer`
- Represents a customer with a name and balance.
- Provides methods to update the customer's balance.

### `exceptions.InsufficientFundsException`
- Custom exception thrown when a customer does not have enough balance to complete a checkout.

## Technologies Used
- **Programming Language**: Java
- **Build Tool**: Maven

## How to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>