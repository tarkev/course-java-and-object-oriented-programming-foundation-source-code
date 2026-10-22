# Java and Object-Oriented Programming Foundation: Lesson Code

Every complete program from the course lessons, as one Java project you can open, build and run.

Requirements: **JDK 21** or newer. Maven is optional.

## Open in an IDE

* **IntelliJ IDEA:** File > Open, select this folder (it contains `pom.xml`), and trust the project. Open any example's
  `Main.java` and click the green run arrow next to `main`.
* **VS Code** (with the Extension Pack for Java) and **Eclipse** (File > Import > Existing Maven Projects) work the same
  way.

## Run from the command line

With Maven:

```bash
mvn -q compile exec:java -Dexec.mainClass=module01.lesson17.example01.Main
```

Without Maven, using only the JDK:

```bash
./run.sh module01.lesson17.example01.Main      # macOS / Linux
run.cmd module01.lesson17.example01.Main       # Windows
```

Both scripts compile every example into `target/classes`, then run the class you name. Examples that read input with
`Scanner` wait for you to type in the terminal.

## How the code is organized

```text
src/main/java/
  module01/                 one package per course module
    lesson17/               one package per lesson
      example01/Main.java   one package per complete program, in lesson order
```

* Each example is in its own package, so its `Main` and helper classes do not clash with other examples.
* In the lessons, examples use packages such as `com.tarkev.course`. Here that part is nested inside the example's
  package, for example `module03.lesson11.example01.course`. Everything else is exactly as in the lesson.
* Example numbers follow the order of complete programs in the lesson. A missing number is a program that does not
  compile on purpose (a compile-error demo).

## Examples

### Module 1: Programming and Java Fundamentals

| Lesson                                               | Example                                         | Main class                                      |
|------------------------------------------------------|-------------------------------------------------|-------------------------------------------------|
| 1.01 Introduction to Programming                     | [1](src/main/java/module01/lesson01/example01)  | `module01.lesson01.example01.Main`              |
| 1.02 How a Computer Executes a Program               | [1](src/main/java/module01/lesson02/example01)  | `module01.lesson02.example01.Main`              |
| 1.03 Introduction to Java                            | [1](src/main/java/module01/lesson03/example01)  | `module01.lesson03.example01.Main`              |
| 1.03 Introduction to Java                            | [2](src/main/java/module01/lesson03/example02)  | `module01.lesson03.example02.Main`              |
| 1.04 JDK, JRE, JVM, and Bytecode                     | [1](src/main/java/module01/lesson04/example01)  | `module01.lesson04.example01.Main`              |
| 1.04 JDK, JRE, JVM, and Bytecode                     | [2](src/main/java/module01/lesson04/example02)  | `module01.lesson04.example02.Main`              |
| 1.05 Setting Up the Java Development Environment     | [1](src/main/java/module01/lesson05/example01)  | `module01.lesson05.example01.Main`              |
| 1.05 Setting Up the Java Development Environment     | [2](src/main/java/module01/lesson05/example02)  | `module01.lesson05.example02.Main`              |
| 1.05 Setting Up the Java Development Environment     | [3](src/main/java/module01/lesson05/example03)  | `module01.lesson05.example03.SetupTest`         |
| 1.05 Setting Up the Java Development Environment     | [4](src/main/java/module01/lesson05/example04)  | `module01.lesson05.example04.EnvironmentCheck`  |
| 1.06 Creating Your First Java Project                | [1](src/main/java/module01/lesson06/example01)  | `module01.lesson06.example01.Main`              |
| 1.06 Creating Your First Java Project                | [2](src/main/java/module01/lesson06/example02)  | `module01.lesson06.example02.Main`              |
| 1.06 Creating Your First Java Project                | [3](src/main/java/module01/lesson06/example03)  | `module01.lesson06.example03.Main`              |
| 1.06 Creating Your First Java Project                | [4](src/main/java/module01/lesson06/example04)  | `module01.lesson06.example04.Main`              |
| 1.06 Creating Your First Java Project                | [5](src/main/java/module01/lesson06/example05)  | `module01.lesson06.example05.Main`              |
| 1.07 Understanding the First Java Program            | [1](src/main/java/module01/lesson07/example01)  | `module01.lesson07.example01.Main`              |
| 1.07 Understanding the First Java Program            | [2](src/main/java/module01/lesson07/example02)  | `module01.lesson07.example02.Main`              |
| 1.07 Understanding the First Java Program            | [3](src/main/java/module01/lesson07/example03)  | `module01.lesson07.example03.Application`       |
| 1.07 Understanding the First Java Program            | [4](src/main/java/module01/lesson07/example04)  | `module01.lesson07.example04.Main`              |
| 1.07 Understanding the First Java Program            | [5](src/main/java/module01/lesson07/example05)  | `module01.lesson07.example05.Main`              |
| 1.07 Understanding the First Java Program            | [6](src/main/java/module01/lesson07/example06)  | `module01.lesson07.example06.Main`              |
| 1.07 Understanding the First Java Program            | [7](src/main/java/module01/lesson07/example07)  | `module01.lesson07.example07.Main`              |
| 1.07 Understanding the First Java Program            | [8](src/main/java/module01/lesson07/example08)  | `module01.lesson07.example08.Main`              |
| 1.07 Understanding the First Java Program            | [9](src/main/java/module01/lesson07/example09)  | `module01.lesson07.example09.Main`              |
| 1.07 Understanding the First Java Program            | [11](src/main/java/module01/lesson07/example11) | `module01.lesson07.example11.Main`              |
| 1.07 Understanding the First Java Program            | [12](src/main/java/module01/lesson07/example12) | `module01.lesson07.example12.CourseApplication` |
| 1.07 Understanding the First Java Program            | [13](src/main/java/module01/lesson07/example13) | `module01.lesson07.example13.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [1](src/main/java/module01/lesson08/example01)  | `module01.lesson08.example01.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [2](src/main/java/module01/lesson08/example02)  | `module01.lesson08.example02.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [3](src/main/java/module01/lesson08/example03)  | `module01.lesson08.example03.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [4](src/main/java/module01/lesson08/example04)  | `module01.lesson08.example04.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [5](src/main/java/module01/lesson08/example05)  | `module01.lesson08.example05.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [6](src/main/java/module01/lesson08/example06)  | `module01.lesson08.example06.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [8](src/main/java/module01/lesson08/example08)  | `module01.lesson08.example08.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [9](src/main/java/module01/lesson08/example09)  | `module01.lesson08.example09.CourseInformation` |
| 1.08 Java Syntax and Coding Conventions              | [11](src/main/java/module01/lesson08/example11) | `module01.lesson08.example11.Main`              |
| 1.09 Variables and Constants                         | [1](src/main/java/module01/lesson09/example01)  | `module01.lesson09.example01.Main`              |
| 1.09 Variables and Constants                         | [2](src/main/java/module01/lesson09/example02)  | `module01.lesson09.example02.Main`              |
| 1.09 Variables and Constants                         | [3](src/main/java/module01/lesson09/example03)  | `module01.lesson09.example03.Main`              |
| 1.09 Variables and Constants                         | [4](src/main/java/module01/lesson09/example04)  | `module01.lesson09.example04.Main`              |
| 1.09 Variables and Constants                         | [5](src/main/java/module01/lesson09/example05)  | `module01.lesson09.example05.Main`              |
| 1.09 Variables and Constants                         | [6](src/main/java/module01/lesson09/example06)  | `module01.lesson09.example06.Main`              |
| 1.09 Variables and Constants                         | [7](src/main/java/module01/lesson09/example07)  | `module01.lesson09.example07.Main`              |
| 1.09 Variables and Constants                         | [8](src/main/java/module01/lesson09/example08)  | `module01.lesson09.example08.Main`              |
| 1.10 Primitive Data Types                            | [1](src/main/java/module01/lesson10/example01)  | `module01.lesson10.example01.Main`              |
| 1.11 Strings and Text Values                         | [1](src/main/java/module01/lesson11/example01)  | `module01.lesson11.example01.Main`              |
| 1.12 Operators and Expressions                       | [1](src/main/java/module01/lesson12/example01)  | `module01.lesson12.example01.Main`              |
| 1.12 Operators and Expressions                       | [2](src/main/java/module01/lesson12/example02)  | `module01.lesson12.example02.Main`              |
| 1.13 Type Conversion and Casting                     | [1](src/main/java/module01/lesson13/example01)  | `module01.lesson13.example01.Main`              |
| 1.13 Type Conversion and Casting                     | [2](src/main/java/module01/lesson13/example02)  | `module01.lesson13.example02.Main`              |
| 1.14 Reading User Input                              | [1](src/main/java/module01/lesson14/example01)  | `module01.lesson14.example01.Main`              |
| 1.14 Reading User Input                              | [2](src/main/java/module01/lesson14/example02)  | `module01.lesson14.example02.Main`              |
| 1.14 Reading User Input                              | [3](src/main/java/module01/lesson14/example03)  | `module01.lesson14.example03.Main`              |
| 1.14 Reading User Input                              | [4](src/main/java/module01/lesson14/example04)  | `module01.lesson14.example04.Main`              |
| 1.15 Conditional Statements                          | [1](src/main/java/module01/lesson15/example01)  | `module01.lesson15.example01.Main`              |
| 1.15 Conditional Statements                          | [2](src/main/java/module01/lesson15/example02)  | `module01.lesson15.example02.Main`              |
| 1.16 Switch Expressions and Statements               | [1](src/main/java/module01/lesson16/example01)  | `module01.lesson16.example01.Main`              |
| 1.17 For Loops                                       | [1](src/main/java/module01/lesson17/example01)  | `module01.lesson17.example01.Main`              |
| 1.18 While and Do-While Loops                        | [1](src/main/java/module01/lesson18/example01)  | `module01.lesson18.example01.Main`              |
| 1.18 While and Do-While Loops                        | [2](src/main/java/module01/lesson18/example02)  | `module01.lesson18.example02.Main`              |
| 1.18 While and Do-While Loops                        | [3](src/main/java/module01/lesson18/example03)  | `module01.lesson18.example03.Main`              |
| 1.18 While and Do-While Loops                        | [4](src/main/java/module01/lesson18/example04)  | `module01.lesson18.example04.Main`              |
| 1.18 While and Do-While Loops                        | [5](src/main/java/module01/lesson18/example05)  | `module01.lesson18.example05.Main`              |
| 1.19 Break, Continue, and Loop Control               | [1](src/main/java/module01/lesson19/example01)  | `module01.lesson19.example01.Main`              |
| 1.20 Project: Build a Console-Based Grade Calculator | [1](src/main/java/module01/lesson20/example01)  | `module01.lesson20.example01.Main`              |

### Module 2: Methods, Arrays, and Program Structure

| Lesson                                                    | Example                                         | Main class                         |
|-----------------------------------------------------------|-------------------------------------------------|------------------------------------|
| 2.01 Introduction to Methods                              | [1](src/main/java/module02/lesson01/example01)  | `module02.lesson01.example01.Main` |
| 2.01 Introduction to Methods                              | [2](src/main/java/module02/lesson01/example02)  | `module02.lesson01.example02.Main` |
| 2.01 Introduction to Methods                              | [3](src/main/java/module02/lesson01/example03)  | `module02.lesson01.example03.Main` |
| 2.01 Introduction to Methods                              | [4](src/main/java/module02/lesson01/example04)  | `module02.lesson01.example04.Main` |
| 2.01 Introduction to Methods                              | [5](src/main/java/module02/lesson01/example05)  | `module02.lesson01.example05.Main` |
| 2.01 Introduction to Methods                              | [6](src/main/java/module02/lesson01/example06)  | `module02.lesson01.example06.Main` |
| 2.01 Introduction to Methods                              | [7](src/main/java/module02/lesson01/example07)  | `module02.lesson01.example07.Main` |
| 2.01 Introduction to Methods                              | [8](src/main/java/module02/lesson01/example08)  | `module02.lesson01.example08.Main` |
| 2.01 Introduction to Methods                              | [9](src/main/java/module02/lesson01/example09)  | `module02.lesson01.example09.Main` |
| 2.01 Introduction to Methods                              | [10](src/main/java/module02/lesson01/example10) | `module02.lesson01.example10.Main` |
| 2.01 Introduction to Methods                              | [11](src/main/java/module02/lesson01/example11) | `module02.lesson01.example11.Main` |
| 2.01 Introduction to Methods                              | [12](src/main/java/module02/lesson01/example12) | `module02.lesson01.example12.Main` |
| 2.01 Introduction to Methods                              | [13](src/main/java/module02/lesson01/example13) | `module02.lesson01.example13.Main` |
| 2.01 Introduction to Methods                              | [15](src/main/java/module02/lesson01/example15) | `module02.lesson01.example15.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [1](src/main/java/module02/lesson02/example01)  | `module02.lesson02.example01.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [2](src/main/java/module02/lesson02/example02)  | `module02.lesson02.example02.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [3](src/main/java/module02/lesson02/example03)  | `module02.lesson02.example03.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [2](src/main/java/module02/lesson03/example02)  | `module02.lesson03.example02.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [3](src/main/java/module02/lesson03/example03)  | `module02.lesson03.example03.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [4](src/main/java/module02/lesson03/example04)  | `module02.lesson03.example04.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [5](src/main/java/module02/lesson03/example05)  | `module02.lesson03.example05.Main` |
| 2.04 Introduction to Arrays                               | [1](src/main/java/module02/lesson04/example01)  | `module02.lesson04.example01.Main` |
| 2.04 Introduction to Arrays                               | [2](src/main/java/module02/lesson04/example02)  | `module02.lesson04.example02.Main` |
| 2.05 Traversing and Working with Arrays                   | [1](src/main/java/module02/lesson05/example01)  | `module02.lesson05.example01.Main` |
| 2.06 Two-Dimensional and Multidimensional Arrays          | [1](src/main/java/module02/lesson06/example01)  | `module02.lesson06.example01.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [1](src/main/java/module02/lesson07/example01)  | `module02.lesson07.example01.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [2](src/main/java/module02/lesson07/example02)  | `module02.lesson07.example02.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [3](src/main/java/module02/lesson07/example03)  | `module02.lesson07.example03.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [4](src/main/java/module02/lesson07/example04)  | `module02.lesson07.example04.Main` |
| 2.08 Introduction to Recursion                            | [1](src/main/java/module02/lesson08/example01)  | `module02.lesson08.example01.Main` |
| 2.08 Introduction to Recursion                            | [2](src/main/java/module02/lesson08/example02)  | `module02.lesson08.example02.Main` |

### Module 3: Object-Oriented Programming Foundations

| Lesson                                                               | Example                                                  | Main class                         |
|----------------------------------------------------------------------|----------------------------------------------------------|------------------------------------|
| 3.01 Introduction to Object-Oriented Design                          | [1](src/main/java/module03/lesson01/example01)           | `module03.lesson01.example01.Main` |
| 3.02 Classes, Objects, Fields, and Methods                           | [1](src/main/java/module03/lesson02/example01) (2 files) | `module03.lesson02.example01.Main` |
| 3.03 Constructors and Valid Object Creation                          | [1](src/main/java/module03/lesson03/example01) (2 files) | `module03.lesson03.example01.Main` |
| 3.04 The `this` Keyword and Method Overloading                       | [1](src/main/java/module03/lesson04/example01) (2 files) | `module03.lesson04.example01.Main` |
| 3.05 Encapsulation, Access Control, and Object Invariants            | [1](src/main/java/module03/lesson05/example01) (2 files) | `module03.lesson05.example01.Main` |
| 3.06 Static and Instance Members                                     | [2](src/main/java/module03/lesson06/example02) (3 files) | `module03.lesson06.example02.Main` |
| 3.07 Object References, `null`, Identity, Equality, and `toString()` | [1](src/main/java/module03/lesson07/example01) (2 files) | `module03.lesson07.example01.Main` |
| 3.08 Composition and Object Relationships                            | [1](src/main/java/module03/lesson08/example01) (4 files) | `module03.lesson08.example01.Main` |
| 3.10 Packages and Organizing Java Code                               | [1](src/main/java/module03/lesson10/example01) (5 files) | `module03.lesson10.example01.Main` |
| 3.11 Project: Build a Course Enrollment System                       | [1](src/main/java/module03/lesson11/example01) (5 files) | `module03.lesson11.example01.Main` |

### Module 4: Inheritance, Interfaces, and Polymorphism

| Lesson                                                  | Example                                                   | Main class                         |
|---------------------------------------------------------|-----------------------------------------------------------|------------------------------------|
| 4.01 Introduction to Inheritance                        | [1](src/main/java/module04/lesson01/example01) (4 files)  | `module04.lesson01.example01.Main` |
| 4.02 Parent Construction, `super`, and Inherited Access | [1](src/main/java/module04/lesson02/example01) (3 files)  | `module04.lesson02.example01.Main` |
| 4.03 Method Overriding and Runtime Polymorphism         | [1](src/main/java/module04/lesson03/example01) (5 files)  | `module04.lesson03.example01.Main` |
| 4.04 Abstract Classes and Interfaces                    | [1](src/main/java/module04/lesson04/example01) (7 files)  | `module04.lesson04.example01.Main` |
| 4.05 Polymorphic Methods and Collections                | [1](src/main/java/module04/lesson05/example01) (6 files)  | `module04.lesson05.example01.Main` |
| 4.06 Interfaces and Dependency Design                   | [2](src/main/java/module04/lesson06/example02) (6 files)  | `module04.lesson06.example02.Main` |
| 4.08 Project: Polymorphic content system                | [1](src/main/java/module04/lesson08/example01) (15 files) | `module04.lesson08.example01.Main` |

### Module 5: Generics, Collections, and Core Data Structures

| Lesson                                      | Example                                                  | Main class                         |
|---------------------------------------------|----------------------------------------------------------|------------------------------------|
| 5.02 Working with `List`                    | [1](src/main/java/module05/lesson02/example01) (2 files) | `module05.lesson02.example01.Main` |
| 5.03 Working with `Set`                     | [1](src/main/java/module05/lesson03/example01) (3 files) | `module05.lesson03.example01.Main` |
| 5.04 Working with `Map`                     | [1](src/main/java/module05/lesson04/example01) (4 files) | `module05.lesson04.example01.Main` |
| 5.05 Queues and FIFO Processing             | [1](src/main/java/module05/lesson05/example01)           | `module05.lesson05.example01.Main` |
| 5.05 Queues and FIFO Processing             | [2](src/main/java/module05/lesson05/example02)           | `module05.lesson05.example02.Main` |
| 5.06 Deque, Stack, and `ArrayDeque`         | [1](src/main/java/module05/lesson06/example01)           | `module05.lesson06.example01.Main` |
| 5.06 Deque, Stack, and `ArrayDeque`         | [2](src/main/java/module05/lesson06/example02)           | `module05.lesson06.example02.Main` |
| 5.06 Deque, Stack, and `ArrayDeque`         | [3](src/main/java/module05/lesson06/example03)           | `module05.lesson06.example03.Main` |
| 5.06 Deque, Stack, and `ArrayDeque`         | [4](src/main/java/module05/lesson06/example04)           | `module05.lesson06.example04.Main` |
| 5.07 Iteration and Collection Operations    | [1](src/main/java/module05/lesson07/example01) (3 files) | `module05.lesson07.example01.Main` |
| 5.08 Designing Classes That Own Collections | [1](src/main/java/module05/lesson08/example01) (3 files) | `module05.lesson08.example01.Main` |

### Module 6: Algorithms and Problem Solving with Java

| Lesson                                              | Example                                                  | Main class                         |
|-----------------------------------------------------|----------------------------------------------------------|------------------------------------|
| 6.02 Simple Sorting Algorithms                      | [1](src/main/java/module06/lesson02/example01)           | `module06.lesson02.example01.Main` |
| 6.03 Merge Sort and Quick Sort                      | [1](src/main/java/module06/lesson03/example01)           | `module06.lesson03.example01.Main` |
| 6.04 Linear Search and Binary Search                | [1](src/main/java/module06/lesson04/example01)           | `module06.lesson04.example01.Main` |
| 6.04 Linear Search and Binary Search                | [2](src/main/java/module06/lesson04/example02)           | `module06.lesson04.example02.Main` |
| 6.04 Linear Search and Binary Search                | [3](src/main/java/module06/lesson04/example03)           | `module06.lesson04.example03.Main` |
| 6.05 Java's Built-In Sorting and Searching APIs     | [1](src/main/java/module06/lesson05/example01) (2 files) | `module06.lesson05.example01.Main` |
| 6.05 Java's Built-In Sorting and Searching APIs     | [2](src/main/java/module06/lesson05/example02) (2 files) | `module06.lesson05.example02.Main` |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [1](src/main/java/module06/lesson06/example01)           | `module06.lesson06.example01.Main` |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [2](src/main/java/module06/lesson06/example02)           | `module06.lesson06.example02.Main` |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [3](src/main/java/module06/lesson06/example03)           | `module06.lesson06.example03.Main` |
| 6.07 Heaps and PriorityQueue                        | [1](src/main/java/module06/lesson07/example01)           | `module06.lesson07.example01.Main` |

### Module 7: Modern Java

| Lesson                                                  | Example                                        | Main class                         |
|---------------------------------------------------------|------------------------------------------------|------------------------------------|
| 7.02 Functional Interfaces and Method References        | [1](src/main/java/module07/lesson02/example01) | `module07.lesson02.example01.Main` |
| 7.03 Introduction to the Stream API                     | [1](src/main/java/module07/lesson03/example01) | `module07.lesson03.example01.Main` |
| 7.06 Optional and Modern Null Handling                  | [1](src/main/java/module07/lesson06/example01) | `module07.lesson06.example01.Main` |
| 7.08 Modern Java Language Features                      | [1](src/main/java/module07/lesson08/example01) | `module07.lesson08.example01.Main` |
| 7.09 Records and Modern Data Models                     | [1](src/main/java/module07/lesson09/example01) | `module07.lesson09.example01.Main` |
| 7.10 Introduction to Concurrency and Thread Safety      | [1](src/main/java/module07/lesson10/example01) | `module07.lesson10.example01.Main` |
| 7.11 Executors, Callable, Future, and CompletableFuture | [1](src/main/java/module07/lesson11/example01) | `module07.lesson11.example01.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [1](src/main/java/module07/lesson12/example01) | `module07.lesson12.example01.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [2](src/main/java/module07/lesson12/example02) | `module07.lesson12.example02.Main` |

### Module 8: Enums, Exceptions, and Robust Error Handling

| Lesson                               | Example                                                  | Main class                         |
|--------------------------------------|----------------------------------------------------------|------------------------------------|
| 8.01 Enums and Domain States         | [1](src/main/java/module08/lesson01/example01) (3 files) | `module08.lesson01.example01.Main` |
| 8.04 Checked vs Unchecked Exceptions | [1](src/main/java/module08/lesson04/example01) (3 files) | `module08.lesson04.example01.Main` |

### Module 9: File Handling and I/O

| Lesson                                           | Example                                                  | Main class                         |
|--------------------------------------------------|----------------------------------------------------------|------------------------------------|
| 9.01 Understanding Files, Paths, and Directories | [1](src/main/java/module09/lesson01/example01)           | `module09.lesson01.example01.Main` |
| 9.02 Reading Text Files                          | [1](src/main/java/module09/lesson02/example01)           | `module09.lesson02.example01.Main` |
| 9.07 Designing a File-Based Repository           | [1](src/main/java/module09/lesson07/example01) (7 files) | `module09.lesson07.example01.Main` |

### Module 10: Professional Java Practices

| Lesson                                           | Example                                                  | Main class                         |
|--------------------------------------------------|----------------------------------------------------------|------------------------------------|
| 10.01 Organizing Java Applications with Packages | [1](src/main/java/module10/lesson01/example01) (6 files) | `module10.lesson01.example01.Main` |
| 10.08 Designing Clear APIs and Boundaries        | [1](src/main/java/module10/lesson08/example01)           | `module10.lesson08.example01.Main` |
