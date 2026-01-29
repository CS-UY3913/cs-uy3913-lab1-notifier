# Lab 1 – Java OOP, Inheritance & Toolchain Setup

**Course:** CS-UY 3913 – Software Engineering  
**Instructor:** Prof. Salim Arfaoui ([sa6468@nyu.edu](mailto:sa6468@nyu.edu))

---

## Lab Goals

By completing this lab, you will:

- Implement a notifier chain using **interfaces** and **inheritance**
- Practice core OOP principles: **composition**, **polymorphism**, and the **decorator pattern**
- Set up and use **Maven** for dependency management and builds
- Write and run **JUnit 5** unit tests
- Understand how to structure and test a real-world notification system

---

## Objective

This lab focuses on applying core object-oriented programming concepts in Java, including interfaces, inheritance, and polymorphism. Students will also gain experience setting up a professional Java toolchain using IntelliJ and Maven, and writing unit tests using JUnit 5.

---

## Lab Tasks and Instructions

### Setup

1. Install **Java 17**, **IntelliJ IDEA**, and **Maven** as outlined in the toolchain setup guide (macOS/Windows).
2. Clone or download the starter code repository:
   ```bash
   git clone https://github.com/bblackheart013/cs-uy3913-lab1-notifier.git
   cd cs-uy3913-lab1-notifier
   ```
3. Open the project in IntelliJ and ensure that Maven recognizes the `pom.xml` file.

### Part 1: Interface and Basic Implementations

1. Define a `Notifier` interface with the method:
   ```java
   void send(String message);
   ```

2. Implement the following classes:
   - `EmailNotifier`
   - `SmsNotifier`
   - `SlackNotifier`

   Each class should output a message to the console simulating a notification.

### Part 2: Decorator Implementations

Implement additional classes that extend `Notifier`:

- `LoggingNotifier`: logs the message before and after sending
- `RetryingNotifier`: simulates retrying failed messages
- `CompositeNotifier`: sends the same message to multiple notifiers

### Part 3: Notification Service

Implement a `NotificationService` class that uses a `Notifier` instance to send a predefined welcome message (e.g., "Welcome to CS-UY 3913").

### Part 4: Testing

1. Create a `FakeNotifier` implementation for testing purposes. It should record whether a message was sent.
2. Write a JUnit 5 test for `NotificationService.sendWelcome()` using `FakeNotifier`.
3. Verify that the message is correctly "sent" using assertions.

### Part 5: Build and Run

1. Ensure that `mvn clean test` runs successfully from the terminal.
2. Use IntelliJ to run the application and confirm the expected console output.

---

## Project Structure

```
cs-uy3913-lab1-notifier/
├── pom.xml
├── README.md
└── src/
    ├── main/java/notifier/
    │   ├── Notifier.java              ← Interface (provided)
    │   ├── EmailNotifier.java         ← TODO: Implement
    │   ├── SmsNotifier.java           ← TODO: Implement
    │   ├── SlackNotifier.java         ← TODO: Implement
    │   ├── LoggingNotifier.java       ← TODO: Implement
    │   ├── RetryingNotifier.java      ← TODO: Implement
    │   ├── CompositeNotifier.java     ← TODO: Implement
    │   └── NotificationService.java   ← TODO: Implement
    └── test/java/notifier/
        └── NotificationServiceTest.java  ← DO NOT MODIFY
```

---

## Important: Do Not Modify Test Files

⚠️ **The test file (`NotificationServiceTest.java`) is used by the autograder. Do not modify it.**

Your code will be graded based on how many tests pass. Modifying the test file may cause all tests to fail on Gradescope.

---

## Building and Running Tests

### Using Terminal

```bash
# Clean and run all tests
mvn clean test

# Expected output (after implementation):
# Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
# BUILD SUCCESS
```

### Using IntelliJ

1. Right-click on `src/test/java`
2. Select **Run 'All Tests'**
3. View results in the Run panel

---

## Submission Instructions (Gradescope)

### Before You Submit

**Your code MUST pass `mvn clean test` locally before submitting.**

```bash
mvn clean test
```

If this fails on your machine, it will fail on Gradescope.

### What to Submit

Submit a **zip file** containing your Java source files from `src/main/java/notifier/`.

### Required Files (8 total)

| File | Description |
|------|-------------|
| `Notifier.java` | Interface |
| `EmailNotifier.java` | Part 1 |
| `SmsNotifier.java` | Part 1 |
| `SlackNotifier.java` | Part 1 |
| `LoggingNotifier.java` | Part 2 |
| `RetryingNotifier.java` | Part 2 |
| `CompositeNotifier.java` | Part 2 |
| `NotificationService.java` | Part 3 |

### How to Create Your Submission Zip

**Option 1: Zip the notifier folder (Recommended)**
```bash
cd your-project/src/main/java
zip -r submission.zip notifier/
```

**Option 2: Zip just the Java files**
```bash
cd your-project/src/main/java/notifier
zip submission.zip *.java
```

**Option 3: From IntelliJ/Finder**
1. Navigate to `src/main/java/`
2. Right-click the `notifier` folder
3. Select "Compress" or "Create Archive"
4. Upload the resulting zip file

---

## Grading (100 Points Total)

| Test | Component | Points |
|------|-----------|--------|
| `testEmailNotifierSendsMessage` | EmailNotifier | 10 |
| `testSmsNotifierSendsMessage` | SmsNotifier | 10 |
| `testSlackNotifierSendsMessage` | SlackNotifier | 10 |
| `testLoggingNotifierLogsBeforeAndAfter` | LoggingNotifier | 10 |
| `testRetryingNotifierSuccess` | RetryingNotifier | 10 |
| `testCompositeNotifierSendsToAll` | CompositeNotifier | 10 |
| `testFakeNotifierRecordsMessage` | FakeNotifier | 10 |
| `testSendWelcomeCallsNotifier` | NotificationService | 10 |
| `testSendWelcomeIncludesUsername` | NotificationService | 10 |
| `testSendWelcomeIncludesWelcome` | NotificationService | 10 |
| **Total** | | **100** |

---

## Troubleshooting

### IntelliJ Issues

| Problem | Solution |
|---------|----------|
| Project not recognized as Maven | Right-click `pom.xml` → "Add as Maven Project" |
| Red underlines everywhere | File → Invalidate Caches → Restart |
| Cannot resolve symbol 'Notifier' | Ensure file has `package notifier;` at top |
| Test file shows errors | Right-click `src/test/java` → Mark Directory as → Test Sources Root |

### Java SDK Issues

| Problem | Solution |
|---------|----------|
| "Java SDK not configured" | File → Project Structure → SDK → Select Java 17 |
| Wrong Java version | Ensure JAVA_HOME points to Java 17 |
| `mvn` not found | Install Maven and add to PATH |

### Maven Build Errors

| Error | Solution |
|-------|----------|
| "Compilation failure" | Check for syntax errors in your code |
| "Cannot find symbol" | Ensure all classes are in the `notifier` package |
| "Test failures" | Read the error messages - they tell you what's wrong |
| Dependencies not downloading | Check internet connection; try `mvn clean install -U` |

### Common Code Errors

| Error | Solution |
|-------|----------|
| "package notifier does not exist" | Add `package notifier;` as first line in each file |
| "cannot find symbol: EmailNotifier" | Ensure EmailNotifier has a public constructor |
| NullPointerException in tests | Initialize all fields in constructors |

---

## Implementation Tips

- All classes must be in the `notifier` package (`package notifier;`)
- `NotificationService` must have a constructor that accepts a `Notifier`
- `sendWelcome(String userName)` must call `notifier.send()` with a message containing "Welcome" and the user's name
- Each notifier should print output in the specified format:
  - EmailNotifier: `[EMAIL] Sending to {email}: {message}`
  - SmsNotifier: `[SMS] Sending to {phone}: {message}`
  - SlackNotifier: `[SLACK] Posting to #{channel}: {message}`

---

## Deliverables

- [ ] All 8 classes implemented and compiling
- [ ] `mvn clean test` passes with 10/10 tests
- [ ] Code submitted to Gradescope as zip file
- [ ] Score: 100/100

---

## Need Help?

- **Office Hours:** Check Brightspace for schedule
- **Email:** [sa6468@nyu.edu](mailto:sa6468@nyu.edu)
- **Ed Discussion:** Post questions on the course forum

Good luck! 🚀
