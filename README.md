# Banking System 

A simple banking system that demonstrates core banking operations including deposits, withdrawals, and transaction management using OOP principles.

## Features

- 💰 **Account Management**: Create and manage bank accounts
- 📊 **Transaction Tracking**: Complete history of all transactions with dates
- 💸 **Core Operations**: Deposit, withdraw, and balance inquiry
- 🖥️ **Interactive Interface**: User-friendly console menu system
- ⚠️ **Error Handling**: Comprehensive validation and exception management

## Project Structure

```
BankingSystem/
├── src/
│   ├── Account.java              # Core banking account implementation
│   ├── AccountService.java       # Banking operations interface
│   ├── AccountTest.java          # Automated testing suite
│   ├── ATM.java                  # Interactive user interface
│   └── Transaction.java          # Transaction data model
└── README.md                     # Project documentation
```

## Requirements

- **Java**: JDK 8 or higher
- **IDE**: Any Java IDE (VSCode, IntelliJ, Eclipse) or command line

## Installation & Setup

### Option 1: Clone Repository

```bash
# Clone the repository
git clone https://github.com/AmjedChakhis/BankingSystem.git

# Navigate to project directory
cd BankingService 

# Navigate to source folder
cd src
```

### Option 2: Download ZIP

1. Click the green **"Code"** button on GitHub
2. Select **"Download ZIP"**
3. Extract the ZIP file
4. Open terminal/command prompt in the extracted folder
5. Navigate to `src` folder: `cd src`

## How to Run

### Step 1: Compile the Code

```bash
# Make sure you're in the src directory
cd src

# Compile all Java files
javac *.java

```

### Step 2: Run the Application

#### Interactive Banking App:
```bash
java ATM
```

#### Automated Testing:
```bash
java AccountTest
```

## Usage Guide

### Interactive Mode

When you run `java ATM`, you'll see:

```
Welcome to Banking System
Current Balance: $0

--- MENU ---
1. Deposit
2. Withdraw
3. View Statement
4. Exit
Choose option (1-4): 
```

**Available Operations:**

1. **Deposit**: Add money to your account
   ```
   Choose option (1-4): 1
   Enter deposit amount: $500
   Deposited: $500
   New Balance: $500
   ```

2. **Withdraw**: Remove money from your account
   ```
   Choose option (1-4): 2
   Enter withdrawal amount: $200
   Withdrawn: $200
   New Balance: $300
   ```

3. **View Statement**: See transaction history
   ```
   Choose option (1-4): 3
   
   --- ACCOUNT STATEMENT ---
   Date || Amount || Balance
   28/06/2025 || -200 || 300
   28/06/2025 || 500 || 500
   Current Balance: $300
   ```

4. **Exit**: Close the application

### Testing Mode

Run `java AccountTest` to see automated tests:

```bash
=== Banking System Test ===

Testing the required scenario:
Date || Amount || Balance
14/01/2012 || -500 || 2500
13/01/2012 || 2000 || 3000
10/01/2012 || 1000 || 1000

=== Additional Tests ===
...
```
## Troubleshooting

### Common Issues:

**"javac: command not found"**
```bash
# Check if Java is installed
java -version
javac -version

# If not installed, download from:
# https://www.oracle.com/java/technologies/javase-downloads.html
```

**"Error: Could not find or load main class"**
```bash
# Make sure you're in the src directory
pwd
ls *.java

# Recompile all files
javac *.java

# Run with correct class name
java ATM  # (not ATM.java)
```

**"Exception in thread 'main'"**
```bash
# Check for compilation errors first
javac *.java

# Look for error messages and fix syntax issues
```

### File Structure Check:
```bash
# Verify all required files exist
ls -la
# Should show: Account.java, AccountService.java, AccountTest.java, ATM.java, Transaction.java
```



