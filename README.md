# Lab 1: Object-Oriented Notification System

## Overview

Build a notification system using Java interfaces, inheritance, and the decorator pattern. Test your implementation using JUnit 5.

## Prerequisites

- Java 17+
- Maven 3.6+
- IntelliJ IDEA

## Setup

1. Clone this repository
2. Open the project in IntelliJ IDEA
3. Ensure IntelliJ recognizes the `pom.xml` file

## Project Structure

```
src/
├── main/java/notifier/
│   ├── Notifier.java            # Interface
│   ├── EmailNotifier.java       # Part 1
│   ├── SmsNotifier.java         # Part 1
│   ├── SlackNotifier.java       # Part 1
│   ├── LoggingNotifier.java     # Part 2
│   ├── RetryingNotifier.java    # Part 2
│   ├── CompositeNotifier.java   # Part 2
│   └── NotificationService.java # Part 3
└── test/java/notifier/
    └── NotificationServiceTest.java  # Part 4
```

## Lab Parts

### Part 1: Basic Implementations
Implement `EmailNotifier`, `SmsNotifier`, and `SlackNotifier` classes that implement the `Notifier` interface.

### Part 2: Decorators
Implement `LoggingNotifier`, `RetryingNotifier`, and `CompositeNotifier` using the decorator pattern.

### Part 3: Notification Service
Implement `NotificationService` that uses dependency injection to send welcome messages.

### Part 4: Testing
Create a `FakeNotifier` test double and write JUnit 5 tests for `NotificationService.sendWelcome()`.

## Running Tests

```bash
mvn clean test
```

## Deliverables

- All classes compile without errors
- All tests pass
- Code follows OOP principles covered in class
