------------------------------------------------
Overview of Lab 04 and Programming Assignment 3
------------------------------------------------

# Back to our BankAccount class

- We have the five private fields:
	- `private final String ownerLastName;`
	- `private final String ownerFirstName;`
	- `private final String accountNumber;`
	- `private double checkingBalance;`
	- `private double savingsBalance;`

- And one public static field
	- `public static int objectCount = 0;`

- Since there is only one copy of a static field for all instances of the class, we can use it to keep track of the number of instances of the `BankAccount` class that have been created / instantiated.

- We have a large amount of public methods for maintaining the `BankAccount`.
	- the code has been commented with TODOs and java docs make it clear what needs to be implemented
		- Withdraw from savings and checkings
		- Transfer to savings and checking
		- Deposit to savings and checking
		- `toString()`
		- Get accountNumber, checking or savings balance
	- These will be ***primarily implemented in lab04***

# The EnhancedBankAccount class

- We also have a class, `EnhancedBankAccount`, that `extends` the `BankAccount` class

**Extending the Base Class**	

``` java
class EnhancedBankAccount extends BankAccount
```
- Defines `EnhancedBankAccount` as a ***subclass*** of `BankAccount`
- Defines `BankAccount` as a ***super class*** of `EnhancedBankAccount`

**Caveats with what we can utilize via inheritance**

- Since `EnhancedBankAccount` is a subclass of `BankAccount`, it can ***inherit*** some of the the functionality of `BankAccount`
- However, since the instance fields are ***private*** in `BankAccount`, `EnhancedBankAccount` cannot directly access them.
- We have to use the getter methods of `BankAccount` to indirectly get the values, and use the various methods of `BankAccount` to modify them
- Our `EnhancedBankAccount` class has ***inherited all of the updating functions*** from `BankAccount`, so we do not necessarily need to modify or implement all of them, we can just use them. This will need to be handled on a case by case basis.

**Overview**

- Our `EnhancedBankAccount` class has two fields
	- `private final java.util.ArrayList<Transaction> successfulTransactions;`
	- `private final java.util.ArrayList<Transaction> failedTransactions;`

- The two fields of `EnhancedBankAccount` will be used to ***keep track of all transactions*** that are processed by the `EnhancedBankAccount`

- `EnhancedBankAccount` will utilize the methods of `BankAccount` to perform the actions of ***depositing***, ***transferring***, and ***withdrawing*** funds from the savings and checking accounts
- It uses its own methods to keep track of the transactions
- `EnhancedBankAccount` uses the `Transaction` class to keep track of the **type**, **date**, and **amount** of each transactions
- The two fields of `EnhancedBankAccount` keep lists of all transactions, the ones that were ***successful*** and the ones that were ***unsuccessful***

**Extending the Deposit / Transfer / Withdraw methods to track Transactions**

- `EnhancedBankAccount` has methods that use `BankAccount` functionality for depositing, transferring, and withdrawing funds
- Most of the methods are missing the functionality to perform the transaction tracking
- These will also be ***primarily implemented in lab04***


**Getters for Transaction Lists**
- The functionality for getting lists of transactions is also missing from most of the methods associated with getting information about the various transactions
- These will be ***primarily implemented in programming assignment 3***

**The TransactionType enumeration**

- Here is the enum to be used as our TransactionType

``` java
enum TransactionType
{
	NEW_ACCOUNT, DEPOSIT_TO_CHECKING, DEPOSIT_TO_SAVINGS, WITHDRAW_FROM_SAVINGS, WITHDRAW_FROM_CHECKING, TRANSFER_TO_SAVINGS, TRANSFER_TO_CHECKING
}
```

- See [Enums](28_enums.md) for more details on how enumerations work.

# Summary 

**Lab04 - High Level**

- Lab 4 will be also involve constructing a class **to perform testing of the functionality** you begin implementing in `BankAccount` and `EnhancedBankAccount`
	- The test class is `makeBankAccountsAndTransactions.java`
		- It is used to read a text file of transactions to perform
		- It also has TODOs, which will be **implemented in lab04**
	- Lab04 should be completed first, before doing programming assignment 3
	- Lab04 will be utilized as a starting point for programming assignment 3

**Programming Assignment 3 - High Level**
- Programming assignment 3 is to fill in the missing functionality of `BankAccount` and `EnhancedBankAccount`
- Primarily related to tracking `Transactions` and getting information related to these tracked `Transactions`