# Java and Object-Oriented Programming Foundation: Lesson Code

Course
Link: [https://tarkev.com/o/tarkev/courses/java-and-object-oriented-programming-foundation?lang=en](https://tarkev.com/o/tarkev/courses/java-and-object-oriented-programming-foundation?lang=en)

Every complete program from the course lessons, as one Java project you can open, build and run.

Requirements: **JDK 21** or newer. Maven is optional for the examples and needed for the tests (`mvn test`).

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
* JUnit tests from the lessons are under `src/test/java`, one package per lesson (`module11.lesson10.tests`), next to
  the classes they test under `src/main/java`. Run them with `mvn test`.

## Examples

### Module 1: Programming and Java Fundamentals

| Lesson                                               | Example                                         | Main class                                      |
|------------------------------------------------------|-------------------------------------------------|-------------------------------------------------|
| 1.01 Introduction to Programming                     | [1](src/main/java/module01/lesson01/example01)  | `module01.lesson01.example01.Main`              |
| 1.02 How a Computer Executes a Program               | [1](src/main/java/module01/lesson02/example01)  | `module01.lesson02.example01.Main`              |
| 1.03 Introduction to Java                            | [1](src/main/java/module01/lesson03/example01)  | `module01.lesson03.example01.Main`              |
| 1.04 JDK, JRE, JVM, and Bytecode                     | [1](src/main/java/module01/lesson04/example01)  | `module01.lesson04.example01.Main`              |
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
| 1.07 Understanding the First Java Program            | [2](src/main/java/module01/lesson07/example02)  | `module01.lesson07.example02.Application`       |
| 1.07 Understanding the First Java Program            | [3](src/main/java/module01/lesson07/example03)  | `module01.lesson07.example03.Main`              |
| 1.07 Understanding the First Java Program            | [4](src/main/java/module01/lesson07/example04)  | `module01.lesson07.example04.Main`              |
| 1.07 Understanding the First Java Program            | [5](src/main/java/module01/lesson07/example05)  | `module01.lesson07.example05.Main`              |
| 1.07 Understanding the First Java Program            | [7](src/main/java/module01/lesson07/example07)  | `module01.lesson07.example07.Main`              |
| 1.07 Understanding the First Java Program            | [8](src/main/java/module01/lesson07/example08)  | `module01.lesson07.example08.CourseApplication` |
| 1.07 Understanding the First Java Program            | [9](src/main/java/module01/lesson07/example09)  | `module01.lesson07.example09.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [1](src/main/java/module01/lesson08/example01)  | `module01.lesson08.example01.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [2](src/main/java/module01/lesson08/example02)  | `module01.lesson08.example02.Main`              |
| 1.08 Java Syntax and Coding Conventions              | [3](src/main/java/module01/lesson08/example03)  | `module01.lesson08.example03.CourseInformation` |
| 1.08 Java Syntax and Coding Conventions              | [5](src/main/java/module01/lesson08/example05)  | `module01.lesson08.example05.Main`              |
| 1.09 Variables and Constants                         | [1](src/main/java/module01/lesson09/example01)  | `module01.lesson09.example01.Main`              |
| 1.09 Variables and Constants                         | [2](src/main/java/module01/lesson09/example02)  | `module01.lesson09.example02.Main`              |
| 1.09 Variables and Constants                         | [3](src/main/java/module01/lesson09/example03)  | `module01.lesson09.example03.Main`              |
| 1.09 Variables and Constants                         | [4](src/main/java/module01/lesson09/example04)  | `module01.lesson09.example04.Main`              |
| 1.09 Variables and Constants                         | [5](src/main/java/module01/lesson09/example05)  | `module01.lesson09.example05.Main`              |
| 1.09 Variables and Constants                         | [6](src/main/java/module01/lesson09/example06)  | `module01.lesson09.example06.Main`              |
| 1.09 Variables and Constants                         | [7](src/main/java/module01/lesson09/example07)  | `module01.lesson09.example07.Main`              |
| 1.09 Variables and Constants                         | [9](src/main/java/module01/lesson09/example09)  | `module01.lesson09.example09.Main`              |
| 1.09 Variables and Constants                         | [12](src/main/java/module01/lesson09/example12) | `module01.lesson09.example12.Main`              |
| 1.10 Primitive Data Types                            | [1](src/main/java/module01/lesson10/example01)  | `module01.lesson10.example01.Main`              |
| 1.10 Primitive Data Types                            | [2](src/main/java/module01/lesson10/example02)  | `module01.lesson10.example02.Main`              |
| 1.10 Primitive Data Types                            | [3](src/main/java/module01/lesson10/example03)  | `module01.lesson10.example03.Main`              |
| 1.10 Primitive Data Types                            | [5](src/main/java/module01/lesson10/example05)  | `module01.lesson10.example05.Main`              |
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
| 1.19 Break, Continue, and Loop Control               | [1](src/main/java/module01/lesson19/example01)  | `module01.lesson19.example01.Main`              |
| 1.20 Project: Build a Console-Based Grade Calculator | [1](src/main/java/module01/lesson20/example01)  | `module01.lesson20.example01.Main`              |
| 1.21 Module 1 Review                                 | [1](src/main/java/module01/lesson21/example01)  | `module01.lesson21.example01.Main`              |
| 1.21 Module 1 Review                                 | [2](src/main/java/module01/lesson21/example02)  | `module01.lesson21.example02.Main`              |
| 1.21 Module 1 Review                                 | [3](src/main/java/module01/lesson21/example03)  | `module01.lesson21.example03.Main`              |
| 1.21 Module 1 Review                                 | [4](src/main/java/module01/lesson21/example04)  | `module01.lesson21.example04.Main`              |
| 1.22 Module 1 Practice Solutions: Lessons 1.01–1.06  | [1](src/main/java/module01/lesson22/example01)  | `module01.lesson22.example01.Main`              |
| 1.22 Module 1 Practice Solutions: Lessons 1.01–1.06  | [2](src/main/java/module01/lesson22/example02)  | `module01.lesson22.example02.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [1](src/main/java/module01/lesson23/example01)  | `module01.lesson23.example01.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [2](src/main/java/module01/lesson23/example02)  | `module01.lesson23.example02.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [3](src/main/java/module01/lesson23/example03)  | `module01.lesson23.example03.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [4](src/main/java/module01/lesson23/example04)  | `module01.lesson23.example04.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [5](src/main/java/module01/lesson23/example05)  | `module01.lesson23.example05.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [6](src/main/java/module01/lesson23/example06)  | `module01.lesson23.example06.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [7](src/main/java/module01/lesson23/example07)  | `module01.lesson23.example07.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [8](src/main/java/module01/lesson23/example08)  | `module01.lesson23.example08.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [9](src/main/java/module01/lesson23/example09)  | `module01.lesson23.example09.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [10](src/main/java/module01/lesson23/example10) | `module01.lesson23.example10.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [11](src/main/java/module01/lesson23/example11) | `module01.lesson23.example11.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [12](src/main/java/module01/lesson23/example12) | `module01.lesson23.example12.Main`              |
| 1.23 Module 1 Practice Solutions: Lessons 1.07–1.11  | [13](src/main/java/module01/lesson23/example13) | `module01.lesson23.example13.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [1](src/main/java/module01/lesson24/example01)  | `module01.lesson24.example01.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [2](src/main/java/module01/lesson24/example02)  | `module01.lesson24.example02.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [3](src/main/java/module01/lesson24/example03)  | `module01.lesson24.example03.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [4](src/main/java/module01/lesson24/example04)  | `module01.lesson24.example04.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [5](src/main/java/module01/lesson24/example05)  | `module01.lesson24.example05.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [6](src/main/java/module01/lesson24/example06)  | `module01.lesson24.example06.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [7](src/main/java/module01/lesson24/example07)  | `module01.lesson24.example07.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [8](src/main/java/module01/lesson24/example08)  | `module01.lesson24.example08.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [9](src/main/java/module01/lesson24/example09)  | `module01.lesson24.example09.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [10](src/main/java/module01/lesson24/example10) | `module01.lesson24.example10.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [11](src/main/java/module01/lesson24/example11) | `module01.lesson24.example11.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [12](src/main/java/module01/lesson24/example12) | `module01.lesson24.example12.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [13](src/main/java/module01/lesson24/example13) | `module01.lesson24.example13.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [14](src/main/java/module01/lesson24/example14) | `module01.lesson24.example14.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [15](src/main/java/module01/lesson24/example15) | `module01.lesson24.example15.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [16](src/main/java/module01/lesson24/example16) | `module01.lesson24.example16.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [17](src/main/java/module01/lesson24/example17) | `module01.lesson24.example17.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [18](src/main/java/module01/lesson24/example18) | `module01.lesson24.example18.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [19](src/main/java/module01/lesson24/example19) | `module01.lesson24.example19.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [20](src/main/java/module01/lesson24/example20) | `module01.lesson24.example20.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [21](src/main/java/module01/lesson24/example21) | `module01.lesson24.example21.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [22](src/main/java/module01/lesson24/example22) | `module01.lesson24.example22.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [23](src/main/java/module01/lesson24/example23) | `module01.lesson24.example23.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [24](src/main/java/module01/lesson24/example24) | `module01.lesson24.example24.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [25](src/main/java/module01/lesson24/example25) | `module01.lesson24.example25.Main`              |
| 1.24 Module 1 Practice Solutions: Lessons 1.12–1.16  | [26](src/main/java/module01/lesson24/example26) | `module01.lesson24.example26.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [1](src/main/java/module01/lesson25/example01)  | `module01.lesson25.example01.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [2](src/main/java/module01/lesson25/example02)  | `module01.lesson25.example02.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [3](src/main/java/module01/lesson25/example03)  | `module01.lesson25.example03.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [4](src/main/java/module01/lesson25/example04)  | `module01.lesson25.example04.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [5](src/main/java/module01/lesson25/example05)  | `module01.lesson25.example05.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [6](src/main/java/module01/lesson25/example06)  | `module01.lesson25.example06.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [7](src/main/java/module01/lesson25/example07)  | `module01.lesson25.example07.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [8](src/main/java/module01/lesson25/example08)  | `module01.lesson25.example08.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [9](src/main/java/module01/lesson25/example09)  | `module01.lesson25.example09.Main`              |
| 1.25 Module 1 Practice Solutions: Lessons 1.17–1.21  | [10](src/main/java/module01/lesson25/example10) | `module01.lesson25.example10.Main`              |

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
| 2.01 Introduction to Methods                              | [11](src/main/java/module02/lesson01/example11) | `module02.lesson01.example11.Main` |
| 2.01 Introduction to Methods                              | [12](src/main/java/module02/lesson01/example12) | `module02.lesson01.example12.Main` |
| 2.01 Introduction to Methods                              | [14](src/main/java/module02/lesson01/example14) | `module02.lesson01.example14.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [1](src/main/java/module02/lesson02/example01)  | `module02.lesson02.example01.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [2](src/main/java/module02/lesson02/example02)  | `module02.lesson02.example02.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [3](src/main/java/module02/lesson02/example03)  | `module02.lesson02.example03.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [4](src/main/java/module02/lesson02/example04)  | `module02.lesson02.example04.Main` |
| 2.02 Parameters, Arguments, and Return Values             | [7](src/main/java/module02/lesson02/example07)  | `module02.lesson02.example07.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [2](src/main/java/module02/lesson03/example02)  | `module02.lesson03.example02.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [3](src/main/java/module02/lesson03/example03)  | `module02.lesson03.example03.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [4](src/main/java/module02/lesson03/example04)  | `module02.lesson03.example04.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [6](src/main/java/module02/lesson03/example06)  | `module02.lesson03.example06.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [7](src/main/java/module02/lesson03/example07)  | `module02.lesson03.example07.Main` |
| 2.03 Scope, Static Methods, and Method Overloading        | [8](src/main/java/module02/lesson03/example08)  | `module02.lesson03.example08.Main` |
| 2.04 Introduction to Arrays                               | [1](src/main/java/module02/lesson04/example01)  | `module02.lesson04.example01.Main` |
| 2.04 Introduction to Arrays                               | [2](src/main/java/module02/lesson04/example02)  | `module02.lesson04.example02.Main` |
| 2.04 Introduction to Arrays                               | [3](src/main/java/module02/lesson04/example03)  | `module02.lesson04.example03.Main` |
| 2.04 Introduction to Arrays                               | [4](src/main/java/module02/lesson04/example04)  | `module02.lesson04.example04.Main` |
| 2.04 Introduction to Arrays                               | [5](src/main/java/module02/lesson04/example05)  | `module02.lesson04.example05.Main` |
| 2.04 Introduction to Arrays                               | [6](src/main/java/module02/lesson04/example06)  | `module02.lesson04.example06.Main` |
| 2.04 Introduction to Arrays                               | [7](src/main/java/module02/lesson04/example07)  | `module02.lesson04.example07.Main` |
| 2.05 Traversing and Working with Arrays                   | [1](src/main/java/module02/lesson05/example01)  | `module02.lesson05.example01.Main` |
| 2.06 Two-Dimensional and Multidimensional Arrays          | [1](src/main/java/module02/lesson06/example01)  | `module02.lesson06.example01.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [1](src/main/java/module02/lesson07/example01)  | `module02.lesson07.example01.Main` |
| 2.07 The Arrays Utility Class and Common Array Operations | [2](src/main/java/module02/lesson07/example02)  | `module02.lesson07.example02.Main` |
| 2.08 Introduction to Recursion                            | [1](src/main/java/module02/lesson08/example01)  | `module02.lesson08.example01.Main` |
| 2.09 Module 2 Review                                      | [2](src/main/java/module02/lesson09/example02)  | `module02.lesson09.example02.Main` |
| 2.09 Module 2 Review                                      | [3](src/main/java/module02/lesson09/example03)  | `module02.lesson09.example03.Main` |
| 2.09 Module 2 Review                                      | [4](src/main/java/module02/lesson09/example04)  | `module02.lesson09.example04.Main` |
| 2.09 Module 2 Review                                      | [5](src/main/java/module02/lesson09/example05)  | `module02.lesson09.example05.Main` |
| 2.09 Module 2 Review                                      | [6](src/main/java/module02/lesson09/example06)  | `module02.lesson09.example06.Main` |
| 2.09 Module 2 Review                                      | [7](src/main/java/module02/lesson09/example07)  | `module02.lesson09.example07.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [1](src/main/java/module02/lesson10/example01)  | `module02.lesson10.example01.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [2](src/main/java/module02/lesson10/example02)  | `module02.lesson10.example02.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [3](src/main/java/module02/lesson10/example03)  | `module02.lesson10.example03.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [4](src/main/java/module02/lesson10/example04)  | `module02.lesson10.example04.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [5](src/main/java/module02/lesson10/example05)  | `module02.lesson10.example05.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [6](src/main/java/module02/lesson10/example06)  | `module02.lesson10.example06.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [7](src/main/java/module02/lesson10/example07)  | `module02.lesson10.example07.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [8](src/main/java/module02/lesson10/example08)  | `module02.lesson10.example08.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [9](src/main/java/module02/lesson10/example09)  | `module02.lesson10.example09.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [10](src/main/java/module02/lesson10/example10) | `module02.lesson10.example10.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [11](src/main/java/module02/lesson10/example11) | `module02.lesson10.example11.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [12](src/main/java/module02/lesson10/example12) | `module02.lesson10.example12.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [13](src/main/java/module02/lesson10/example13) | `module02.lesson10.example13.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [14](src/main/java/module02/lesson10/example14) | `module02.lesson10.example14.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [15](src/main/java/module02/lesson10/example15) | `module02.lesson10.example15.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [16](src/main/java/module02/lesson10/example16) | `module02.lesson10.example16.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [17](src/main/java/module02/lesson10/example17) | `module02.lesson10.example17.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [18](src/main/java/module02/lesson10/example18) | `module02.lesson10.example18.Main` |
| 2.10 Module 2 Practice Solutions: Lessons 2.01–2.04       | [19](src/main/java/module02/lesson10/example19) | `module02.lesson10.example19.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [1](src/main/java/module02/lesson11/example01)  | `module02.lesson11.example01.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [2](src/main/java/module02/lesson11/example02)  | `module02.lesson11.example02.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [3](src/main/java/module02/lesson11/example03)  | `module02.lesson11.example03.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [4](src/main/java/module02/lesson11/example04)  | `module02.lesson11.example04.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [5](src/main/java/module02/lesson11/example05)  | `module02.lesson11.example05.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [6](src/main/java/module02/lesson11/example06)  | `module02.lesson11.example06.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [7](src/main/java/module02/lesson11/example07)  | `module02.lesson11.example07.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [8](src/main/java/module02/lesson11/example08)  | `module02.lesson11.example08.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [9](src/main/java/module02/lesson11/example09)  | `module02.lesson11.example09.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [10](src/main/java/module02/lesson11/example10) | `module02.lesson11.example10.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [11](src/main/java/module02/lesson11/example11) | `module02.lesson11.example11.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [12](src/main/java/module02/lesson11/example12) | `module02.lesson11.example12.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [13](src/main/java/module02/lesson11/example13) | `module02.lesson11.example13.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [14](src/main/java/module02/lesson11/example14) | `module02.lesson11.example14.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [15](src/main/java/module02/lesson11/example15) | `module02.lesson11.example15.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [16](src/main/java/module02/lesson11/example16) | `module02.lesson11.example16.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [17](src/main/java/module02/lesson11/example17) | `module02.lesson11.example17.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [18](src/main/java/module02/lesson11/example18) | `module02.lesson11.example18.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [19](src/main/java/module02/lesson11/example19) | `module02.lesson11.example19.Main` |
| 2.11 Module 2 Practice Solutions: Lessons 2.05–2.09       | [20](src/main/java/module02/lesson11/example20) | `module02.lesson11.example20.Main` |

### Module 3: Object-Oriented Programming Foundations

| Lesson                                                               | Example                                                  | Main class                                    |
|----------------------------------------------------------------------|----------------------------------------------------------|-----------------------------------------------|
| 3.02 Classes, Objects, Fields, and Methods                           | [1](src/main/java/module03/lesson02/example01) (2 files) | `module03.lesson02.example01.Main`            |
| 3.03 Constructors and Valid Object Creation                          | [1](src/main/java/module03/lesson03/example01) (2 files) | `module03.lesson03.example01.Main`            |
| 3.04 The `this` Keyword and Method Overloading                       | [1](src/main/java/module03/lesson04/example01) (2 files) | `module03.lesson04.example01.Main`            |
| 3.04 The `this` Keyword and Method Overloading                       | [2](src/main/java/module03/lesson04/example02)           | `module03.lesson04.example02.Workshop`        |
| 3.04 The `this` Keyword and Method Overloading                       | [3](src/main/java/module03/lesson04/example03)           | `module03.lesson04.example03.Main`            |
| 3.04 The `this` Keyword and Method Overloading                       | [4](src/main/java/module03/lesson04/example04)           | `module03.lesson04.example04.Quiz`            |
| 3.05 Encapsulation, Access Control, and Object Invariants            | [1](src/main/java/module03/lesson05/example01) (2 files) | `module03.lesson05.example01.Main`            |
| 3.06 Static and Instance Members                                     | [1](src/main/java/module03/lesson06/example01) (2 files) | `module03.lesson06.example01.Main`            |
| 3.06 Static and Instance Members                                     | [2](src/main/java/module03/lesson06/example02) (3 files) | `module03.lesson06.example02.Main`            |
| 3.07 Object References, `null`, Identity, Equality, and `toString()` | [1](src/main/java/module03/lesson07/example01) (2 files) | `module03.lesson07.example01.Main`            |
| 3.08 Composition and Object Relationships                            | [1](src/main/java/module03/lesson08/example01) (4 files) | `module03.lesson08.example01.Main`            |
| 3.10 Packages and Organizing Java Code                               | [1](src/main/java/module03/lesson10/example01) (5 files) | `module03.lesson10.example01.Main`            |
| 3.11 Project: Build a Course Enrollment System                       | [1](src/main/java/module03/lesson11/example01) (5 files) | `module03.lesson11.example01.Main`            |
| 3.12 Module 3 Review                                                 | [1](src/main/java/module03/lesson12/example01)           | `module03.lesson12.example01.SeatTicketDemo`  |
| 3.12 Module 3 Review                                                 | [2](src/main/java/module03/lesson12/example02)           | `module03.lesson12.example02.DraftCourseDemo` |
| 3.12 Module 3 Review                                                 | [3](src/main/java/module03/lesson12/example03)           | `module03.lesson12.example03.ScoreBoardDemo`  |
| 3.12 Module 3 Review                                                 | [4](src/main/java/module03/lesson12/example04)           | `module03.lesson12.example04.CourseTagDemo`   |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [1](src/main/java/module03/lesson13/example01)           | `module03.lesson13.example01.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [2](src/main/java/module03/lesson13/example02)           | `module03.lesson13.example02.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [3](src/main/java/module03/lesson13/example03)           | `module03.lesson13.example03.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [4](src/main/java/module03/lesson13/example04)           | `module03.lesson13.example04.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [5](src/main/java/module03/lesson13/example05)           | `module03.lesson13.example05.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [6](src/main/java/module03/lesson13/example06)           | `module03.lesson13.example06.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [7](src/main/java/module03/lesson13/example07)           | `module03.lesson13.example07.Main`            |
| 3.13 Module 3 Practice Solutions: Lessons 3.01–3.06                  | [8](src/main/java/module03/lesson13/example08)           | `module03.lesson13.example08.Main`            |
| 3.14 Module 3 Practice Solutions: Lessons 3.07–3.12                  | [1](src/main/java/module03/lesson14/example01) (4 files) | `module03.lesson14.example01.Main`            |

### Module 4: Inheritance, Interfaces, and Polymorphism

| Lesson                                                  | Example                                                   | Main class                                   |
|---------------------------------------------------------|-----------------------------------------------------------|----------------------------------------------|
| 4.01 Introduction to Inheritance                        | [1](src/main/java/module04/lesson01/example01) (4 files)  | `module04.lesson01.example01.Main`           |
| 4.02 Parent Construction, `super`, and Inherited Access | [1](src/main/java/module04/lesson02/example01) (3 files)  | `module04.lesson02.example01.Main`           |
| 4.03 Method Overriding and Runtime Polymorphism         | [1](src/main/java/module04/lesson03/example01) (5 files)  | `module04.lesson03.example01.Main`           |
| 4.04 Abstract Classes and Interfaces                    | [1](src/main/java/module04/lesson04/example01) (7 files)  | `module04.lesson04.example01.Main`           |
| 4.05 Polymorphic Methods and Arrays                     | [1](src/main/java/module04/lesson05/example01) (6 files)  | `module04.lesson05.example01.Main`           |
| 4.06 Interfaces and Dependency Design                   | [1](src/main/java/module04/lesson06/example01) (6 files)  | `module04.lesson06.example01.Main`           |
| 4.08 Project: Polymorphic Content System                | [1](src/main/java/module04/lesson08/example01) (15 files) | `module04.lesson08.example01.Main`           |
| 4.09 Module 4 Review                                    | [1](src/main/java/module04/lesson09/example01)            | `module04.lesson09.example01.DispatchDemo`   |
| 4.09 Module 4 Review                                    | [2](src/main/java/module04/lesson09/example02)            | `module04.lesson09.example02.AbstractDemo`   |
| 4.09 Module 4 Review                                    | [3](src/main/java/module04/lesson09/example03)            | `module04.lesson09.example03.FieldDemo`      |
| 4.09 Module 4 Review                                    | [4](src/main/java/module04/lesson09/example04)            | `module04.lesson09.example04.CapabilityDemo` |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [1](src/main/java/module04/lesson10/example01)            | `module04.lesson10.example01.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [2](src/main/java/module04/lesson10/example02)            | `module04.lesson10.example02.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [3](src/main/java/module04/lesson10/example03)            | `module04.lesson10.example03.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [4](src/main/java/module04/lesson10/example04)            | `module04.lesson10.example04.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [5](src/main/java/module04/lesson10/example05)            | `module04.lesson10.example05.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [6](src/main/java/module04/lesson10/example06)            | `module04.lesson10.example06.Main`           |
| 4.10 Module 4 Practice Solutions: Lessons 4.01–4.04     | [7](src/main/java/module04/lesson10/example07)            | `module04.lesson10.example07.Main`           |
| 4.11 Module 4 Practice Solutions: Lessons 4.05–4.09     | [1](src/main/java/module04/lesson11/example01)            | `module04.lesson11.example01.Main`           |
| 4.11 Module 4 Practice Solutions: Lessons 4.05–4.09     | [2](src/main/java/module04/lesson11/example02)            | `module04.lesson11.example02.Main`           |
| 4.11 Module 4 Practice Solutions: Lessons 4.05–4.09     | [3](src/main/java/module04/lesson11/example03) (8 files)  | `module04.lesson11.example03.Main`           |
| 4.11 Module 4 Practice Solutions: Lessons 4.05–4.09     | [4](src/main/java/module04/lesson11/example04)            | `module04.lesson11.example04.Main`           |

### Module 5: Generics, Collections, and Core Data Structures

| Lesson                                              | Example                                                  | Main class                               |
|-----------------------------------------------------|----------------------------------------------------------|------------------------------------------|
| 5.01 Introduction to Generics and Type Safety       | [1](src/main/java/module05/lesson01/example01)           | `module05.lesson01.example01.Main`       |
| 5.02 Working with `List`                            | [1](src/main/java/module05/lesson02/example01) (2 files) | `module05.lesson02.example01.Main`       |
| 5.03 Working with `Set`                             | [1](src/main/java/module05/lesson03/example01) (3 files) | `module05.lesson03.example01.Main`       |
| 5.04 Working with `Map`                             | [1](src/main/java/module05/lesson04/example01) (4 files) | `module05.lesson04.example01.Main`       |
| 5.05 Queues and FIFO Processing                     | [1](src/main/java/module05/lesson05/example01)           | `module05.lesson05.example01.Main`       |
| 5.05 Queues and FIFO Processing                     | [2](src/main/java/module05/lesson05/example02)           | `module05.lesson05.example02.Main`       |
| 5.06 Deque, Stack, and `ArrayDeque`                 | [1](src/main/java/module05/lesson06/example01)           | `module05.lesson06.example01.Main`       |
| 5.06 Deque, Stack, and `ArrayDeque`                 | [2](src/main/java/module05/lesson06/example02)           | `module05.lesson06.example02.Main`       |
| 5.06 Deque, Stack, and `ArrayDeque`                 | [3](src/main/java/module05/lesson06/example03)           | `module05.lesson06.example03.Main`       |
| 5.06 Deque, Stack, and `ArrayDeque`                 | [4](src/main/java/module05/lesson06/example04)           | `module05.lesson06.example04.Main`       |
| 5.07 Iteration and Collection Operations            | [1](src/main/java/module05/lesson07/example01) (3 files) | `module05.lesson07.example01.Main`       |
| 5.08 Designing Classes That Own Collections         | [1](src/main/java/module05/lesson08/example01) (3 files) | `module05.lesson08.example01.Main`       |
| 5.10 Module 5 Review                                | [1](src/main/java/module05/lesson10/example01)           | `module05.lesson10.example01.Main`       |
| 5.10 Module 5 Review                                | [2](src/main/java/module05/lesson10/example02)           | `module05.lesson10.example02.Main`       |
| 5.10 Module 5 Review                                | [3](src/main/java/module05/lesson10/example03)           | `module05.lesson10.example03.Main`       |
| 5.10 Module 5 Review                                | [4](src/main/java/module05/lesson10/example04)           | `module05.lesson10.example04.Main`       |
| 5.10 Module 5 Review                                | [5](src/main/java/module05/lesson10/example05)           | `module05.lesson10.example05.SetDemo`    |
| 5.10 Module 5 Review                                | [6](src/main/java/module05/lesson10/example06)           | `module05.lesson10.example06.StackDemo`  |
| 5.10 Module 5 Review                                | [7](src/main/java/module05/lesson10/example07)           | `module05.lesson10.example07.CountDemo`  |
| 5.10 Module 5 Review                                | [8](src/main/java/module05/lesson10/example08)           | `module05.lesson10.example08.RemoveDemo` |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [1](src/main/java/module05/lesson11/example01)           | `module05.lesson11.example01.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [2](src/main/java/module05/lesson11/example02)           | `module05.lesson11.example02.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [3](src/main/java/module05/lesson11/example03)           | `module05.lesson11.example03.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [4](src/main/java/module05/lesson11/example04)           | `module05.lesson11.example04.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [5](src/main/java/module05/lesson11/example05)           | `module05.lesson11.example05.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [6](src/main/java/module05/lesson11/example06)           | `module05.lesson11.example06.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [7](src/main/java/module05/lesson11/example07)           | `module05.lesson11.example07.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [8](src/main/java/module05/lesson11/example08)           | `module05.lesson11.example08.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [9](src/main/java/module05/lesson11/example09)           | `module05.lesson11.example09.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [10](src/main/java/module05/lesson11/example10)          | `module05.lesson11.example10.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [11](src/main/java/module05/lesson11/example11)          | `module05.lesson11.example11.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [12](src/main/java/module05/lesson11/example12)          | `module05.lesson11.example12.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [13](src/main/java/module05/lesson11/example13)          | `module05.lesson11.example13.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [14](src/main/java/module05/lesson11/example14)          | `module05.lesson11.example14.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [15](src/main/java/module05/lesson11/example15)          | `module05.lesson11.example15.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [16](src/main/java/module05/lesson11/example16)          | `module05.lesson11.example16.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [17](src/main/java/module05/lesson11/example17)          | `module05.lesson11.example17.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [18](src/main/java/module05/lesson11/example18)          | `module05.lesson11.example18.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [19](src/main/java/module05/lesson11/example19)          | `module05.lesson11.example19.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [20](src/main/java/module05/lesson11/example20)          | `module05.lesson11.example20.Main`       |
| 5.11 Module 5 Practice Solutions: Lessons 5.01–5.05 | [21](src/main/java/module05/lesson11/example21)          | `module05.lesson11.example21.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [1](src/main/java/module05/lesson12/example01)           | `module05.lesson12.example01.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [2](src/main/java/module05/lesson12/example02)           | `module05.lesson12.example02.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [3](src/main/java/module05/lesson12/example03)           | `module05.lesson12.example03.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [4](src/main/java/module05/lesson12/example04)           | `module05.lesson12.example04.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [5](src/main/java/module05/lesson12/example05)           | `module05.lesson12.example05.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [6](src/main/java/module05/lesson12/example06)           | `module05.lesson12.example06.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [7](src/main/java/module05/lesson12/example07)           | `module05.lesson12.example07.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [8](src/main/java/module05/lesson12/example08)           | `module05.lesson12.example08.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [9](src/main/java/module05/lesson12/example09)           | `module05.lesson12.example09.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [10](src/main/java/module05/lesson12/example10)          | `module05.lesson12.example10.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [11](src/main/java/module05/lesson12/example11)          | `module05.lesson12.example11.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [12](src/main/java/module05/lesson12/example12)          | `module05.lesson12.example12.Main`       |
| 5.12 Module 5 Practice Solutions: Lessons 5.06–5.10 | [13](src/main/java/module05/lesson12/example13)          | `module05.lesson12.example13.Main`       |

### Module 6: Algorithms and Problem Solving with Java

| Lesson                                              | Example                                                  | Main class                                     |
|-----------------------------------------------------|----------------------------------------------------------|------------------------------------------------|
| 6.02 Simple Sorting Algorithms                      | [1](src/main/java/module06/lesson02/example01)           | `module06.lesson02.example01.Main`             |
| 6.03 Merge Sort and Quick Sort                      | [1](src/main/java/module06/lesson03/example01)           | `module06.lesson03.example01.Main`             |
| 6.04 Linear Search and Binary Search                | [1](src/main/java/module06/lesson04/example01)           | `module06.lesson04.example01.Main`             |
| 6.04 Linear Search and Binary Search                | [2](src/main/java/module06/lesson04/example02)           | `module06.lesson04.example02.Main`             |
| 6.04 Linear Search and Binary Search                | [3](src/main/java/module06/lesson04/example03)           | `module06.lesson04.example03.Main`             |
| 6.05 Java's Built-In Sorting and Searching APIs     | [1](src/main/java/module06/lesson05/example01) (2 files) | `module06.lesson05.example01.Main`             |
| 6.05 Java's Built-In Sorting and Searching APIs     | [2](src/main/java/module06/lesson05/example02) (2 files) | `module06.lesson05.example02.Main`             |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [1](src/main/java/module06/lesson06/example01)           | `module06.lesson06.example01.Main`             |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [2](src/main/java/module06/lesson06/example02)           | `module06.lesson06.example02.Main`             |
| 6.06 Using Stacks, Queues, and Deques in Algorithms | [3](src/main/java/module06/lesson06/example03)           | `module06.lesson06.example03.Main`             |
| 6.07 Heaps and PriorityQueue                        | [1](src/main/java/module06/lesson07/example01)           | `module06.lesson07.example01.Main`             |
| 6.10 Module 6 Review                                | [1](src/main/java/module06/lesson10/example01)           | `module06.lesson10.example01.StopsDemo`        |
| 6.10 Module 6 Review                                | [2](src/main/java/module06/lesson10/example02)           | `module06.lesson10.example02.TopDistancesDemo` |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [1](src/main/java/module06/lesson11/example01)           | `module06.lesson11.example01.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [2](src/main/java/module06/lesson11/example02)           | `module06.lesson11.example02.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [3](src/main/java/module06/lesson11/example03)           | `module06.lesson11.example03.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [4](src/main/java/module06/lesson11/example04)           | `module06.lesson11.example04.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [5](src/main/java/module06/lesson11/example05)           | `module06.lesson11.example05.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [6](src/main/java/module06/lesson11/example06)           | `module06.lesson11.example06.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [7](src/main/java/module06/lesson11/example07)           | `module06.lesson11.example07.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [8](src/main/java/module06/lesson11/example08)           | `module06.lesson11.example08.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [9](src/main/java/module06/lesson11/example09)           | `module06.lesson11.example09.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [10](src/main/java/module06/lesson11/example10)          | `module06.lesson11.example10.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [11](src/main/java/module06/lesson11/example11)          | `module06.lesson11.example11.Main`             |
| 6.11 Module 6 Practice Solutions: Lessons 6.01–6.05 | [12](src/main/java/module06/lesson11/example12)          | `module06.lesson11.example12.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [1](src/main/java/module06/lesson12/example01)           | `module06.lesson12.example01.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [2](src/main/java/module06/lesson12/example02)           | `module06.lesson12.example02.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [3](src/main/java/module06/lesson12/example03)           | `module06.lesson12.example03.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [4](src/main/java/module06/lesson12/example04)           | `module06.lesson12.example04.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [5](src/main/java/module06/lesson12/example05)           | `module06.lesson12.example05.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [6](src/main/java/module06/lesson12/example06)           | `module06.lesson12.example06.Main`             |
| 6.12 Module 6 Practice Solutions: Lessons 6.06–6.10 | [7](src/main/java/module06/lesson12/example07)           | `module06.lesson12.example07.Main`             |

### Module 7: Modern Java

| Lesson                                                  | Example                                         | Main class                         |
|---------------------------------------------------------|-------------------------------------------------|------------------------------------|
| 7.01 Lambda Expressions                                 | [1](src/main/java/module07/lesson01/example01)  | `module07.lesson01.example01.Main` |
| 7.02 Functional Interfaces and Method References        | [1](src/main/java/module07/lesson02/example01)  | `module07.lesson02.example01.Main` |
| 7.02 Functional Interfaces and Method References        | [2](src/main/java/module07/lesson02/example02)  | `module07.lesson02.example02.Main` |
| 7.03 Introduction to the Stream API                     | [1](src/main/java/module07/lesson03/example01)  | `module07.lesson03.example01.Main` |
| 7.03 Introduction to the Stream API                     | [2](src/main/java/module07/lesson03/example02)  | `module07.lesson03.example02.Main` |
| 7.04 Filtering, Mapping, and Transforming Streams       | [1](src/main/java/module07/lesson04/example01)  | `module07.lesson04.example01.Main` |
| 7.04 Filtering, Mapping, and Transforming Streams       | [2](src/main/java/module07/lesson04/example02)  | `module07.lesson04.example02.Main` |
| 7.05 Collectors, Grouping, and Reduction                | [1](src/main/java/module07/lesson05/example01)  | `module07.lesson05.example01.Main` |
| 7.06 Optional and Modern Null Handling                  | [1](src/main/java/module07/lesson06/example01)  | `module07.lesson06.example01.Main` |
| 7.06 Optional and Modern Null Handling                  | [2](src/main/java/module07/lesson06/example02)  | `module07.lesson06.example02.Main` |
| 7.07 The Modern Date and Time API                       | [1](src/main/java/module07/lesson07/example01)  | `module07.lesson07.example01.Main` |
| 7.07 The Modern Date and Time API                       | [2](src/main/java/module07/lesson07/example02)  | `module07.lesson07.example02.Main` |
| 7.07 The Modern Date and Time API                       | [3](src/main/java/module07/lesson07/example03)  | `module07.lesson07.example03.Main` |
| 7.07 The Modern Date and Time API                       | [4](src/main/java/module07/lesson07/example04)  | `module07.lesson07.example04.Main` |
| 7.07 The Modern Date and Time API                       | [5](src/main/java/module07/lesson07/example05)  | `module07.lesson07.example05.Main` |
| 7.08 Modern Java Language Features                      | [1](src/main/java/module07/lesson08/example01)  | `module07.lesson08.example01.Main` |
| 7.08 Modern Java Language Features                      | [2](src/main/java/module07/lesson08/example02)  | `module07.lesson08.example02.Main` |
| 7.09 Records and Modern Data Models                     | [1](src/main/java/module07/lesson09/example01)  | `module07.lesson09.example01.Main` |
| 7.09 Records and Modern Data Models                     | [2](src/main/java/module07/lesson09/example02)  | `module07.lesson09.example02.Main` |
| 7.10 Introduction to Concurrency and Thread Safety      | [1](src/main/java/module07/lesson10/example01)  | `module07.lesson10.example01.Main` |
| 7.10 Introduction to Concurrency and Thread Safety      | [2](src/main/java/module07/lesson10/example02)  | `module07.lesson10.example02.Main` |
| 7.10 Introduction to Concurrency and Thread Safety      | [3](src/main/java/module07/lesson10/example03)  | `module07.lesson10.example03.Main` |
| 7.11 Executors, Callable, Future, and CompletableFuture | [1](src/main/java/module07/lesson11/example01)  | `module07.lesson11.example01.Main` |
| 7.11 Executors, Callable, Future, and CompletableFuture | [2](src/main/java/module07/lesson11/example02)  | `module07.lesson11.example02.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [1](src/main/java/module07/lesson12/example01)  | `module07.lesson12.example01.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [2](src/main/java/module07/lesson12/example02)  | `module07.lesson12.example02.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [3](src/main/java/module07/lesson12/example03)  | `module07.lesson12.example03.Main` |
| 7.12 Virtual Threads and Concurrent Collections         | [4](src/main/java/module07/lesson12/example04)  | `module07.lesson12.example04.Main` |
| 7.13 Module 7 Review                                    | [2](src/main/java/module07/lesson13/example02)  | `module07.lesson13.example02.Main` |
| 7.13 Module 7 Review                                    | [3](src/main/java/module07/lesson13/example03)  | `module07.lesson13.example03.Main` |
| 7.13 Module 7 Review                                    | [4](src/main/java/module07/lesson13/example04)  | `module07.lesson13.example04.Main` |
| 7.13 Module 7 Review                                    | [5](src/main/java/module07/lesson13/example05)  | `module07.lesson13.example05.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [1](src/main/java/module07/lesson14/example01)  | `module07.lesson14.example01.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [2](src/main/java/module07/lesson14/example02)  | `module07.lesson14.example02.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [3](src/main/java/module07/lesson14/example03)  | `module07.lesson14.example03.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [4](src/main/java/module07/lesson14/example04)  | `module07.lesson14.example04.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [5](src/main/java/module07/lesson14/example05)  | `module07.lesson14.example05.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [6](src/main/java/module07/lesson14/example06)  | `module07.lesson14.example06.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [7](src/main/java/module07/lesson14/example07)  | `module07.lesson14.example07.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [8](src/main/java/module07/lesson14/example08)  | `module07.lesson14.example08.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [9](src/main/java/module07/lesson14/example09)  | `module07.lesson14.example09.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [10](src/main/java/module07/lesson14/example10) | `module07.lesson14.example10.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [11](src/main/java/module07/lesson14/example11) | `module07.lesson14.example11.Main` |
| 7.14 Module 7 Practice Solutions: Lessons 7.01–7.04     | [12](src/main/java/module07/lesson14/example12) | `module07.lesson14.example12.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [1](src/main/java/module07/lesson15/example01)  | `module07.lesson15.example01.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [2](src/main/java/module07/lesson15/example02)  | `module07.lesson15.example02.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [3](src/main/java/module07/lesson15/example03)  | `module07.lesson15.example03.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [4](src/main/java/module07/lesson15/example04)  | `module07.lesson15.example04.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [5](src/main/java/module07/lesson15/example05)  | `module07.lesson15.example05.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [6](src/main/java/module07/lesson15/example06)  | `module07.lesson15.example06.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [7](src/main/java/module07/lesson15/example07)  | `module07.lesson15.example07.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [8](src/main/java/module07/lesson15/example08)  | `module07.lesson15.example08.Main` |
| 7.15 Module 7 Practice Solutions: Lessons 7.05–7.08     | [9](src/main/java/module07/lesson15/example09)  | `module07.lesson15.example09.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [1](src/main/java/module07/lesson16/example01)  | `module07.lesson16.example01.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [2](src/main/java/module07/lesson16/example02)  | `module07.lesson16.example02.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [3](src/main/java/module07/lesson16/example03)  | `module07.lesson16.example03.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [4](src/main/java/module07/lesson16/example04)  | `module07.lesson16.example04.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [5](src/main/java/module07/lesson16/example05)  | `module07.lesson16.example05.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [6](src/main/java/module07/lesson16/example06)  | `module07.lesson16.example06.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [7](src/main/java/module07/lesson16/example07)  | `module07.lesson16.example07.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [8](src/main/java/module07/lesson16/example08)  | `module07.lesson16.example08.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [9](src/main/java/module07/lesson16/example09)  | `module07.lesson16.example09.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [10](src/main/java/module07/lesson16/example10) | `module07.lesson16.example10.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [11](src/main/java/module07/lesson16/example11) | `module07.lesson16.example11.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [12](src/main/java/module07/lesson16/example12) | `module07.lesson16.example12.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [13](src/main/java/module07/lesson16/example13) | `module07.lesson16.example13.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [14](src/main/java/module07/lesson16/example14) | `module07.lesson16.example14.Main` |
| 7.16 Module 7 Practice Solutions: Lessons 7.09–7.13     | [15](src/main/java/module07/lesson16/example15) | `module07.lesson16.example15.Main` |

### Module 8: Enums, Exceptions, and Robust Error Handling

| Lesson                                                | Example                                                  | Main class                                  |
|-------------------------------------------------------|----------------------------------------------------------|---------------------------------------------|
| 8.01 Enums and Domain States                          | [1](src/main/java/module08/lesson01/example01) (3 files) | `module08.lesson01.example01.Main`          |
| 8.02 Exceptions and Failure Handling                  | [1](src/main/java/module08/lesson02/example01)           | `module08.lesson02.example01.Main`          |
| 8.02 Exceptions and Failure Handling                  | [2](src/main/java/module08/lesson02/example02) (3 files) | `module08.lesson02.example02.course.Main`   |
| 8.03 `try`, `catch`, `finally`, `throw`, and `throws` | [1](src/main/java/module08/lesson03/example01)           | `module08.lesson03.example01.Main`          |
| 8.03 `try`, `catch`, `finally`, `throw`, and `throws` | [2](src/main/java/module08/lesson03/example02) (2 files) | `module08.lesson03.example02.Main`          |
| 8.04 Checked vs Unchecked Exceptions                  | [2](src/main/java/module08/lesson04/example02) (3 files) | `module08.lesson04.example02.Main`          |
| 8.05 Designing Custom Exceptions                      | [1](src/main/java/module08/lesson05/example01) (2 files) | `module08.lesson05.example01.Main`          |
| 8.06 Validation and Error-Handling Strategies         | [1](src/main/java/module08/lesson06/example01) (5 files) | `module08.lesson06.example01.course.Main`   |
| 8.08 Module 8 Review                                  | [2](src/main/java/module08/lesson08/example02)           | `module08.lesson08.example02.FinallyDemo`   |
| 8.08 Module 8 Review                                  | [3](src/main/java/module08/lesson08/example03)           | `module08.lesson08.example03.HierarchyDemo` |
| 8.08 Module 8 Review                                  | [4](src/main/java/module08/lesson08/example04)           | `module08.lesson08.example04.CauseDemo`     |
| 8.08 Module 8 Review                                  | [5](src/main/java/module08/lesson08/example05)           | `module08.lesson08.example05.LevelDemo`     |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [1](src/main/java/module08/lesson09/example01)           | `module08.lesson09.example01.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [2](src/main/java/module08/lesson09/example02)           | `module08.lesson09.example02.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [3](src/main/java/module08/lesson09/example03)           | `module08.lesson09.example03.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [4](src/main/java/module08/lesson09/example04)           | `module08.lesson09.example04.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [5](src/main/java/module08/lesson09/example05)           | `module08.lesson09.example05.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [6](src/main/java/module08/lesson09/example06)           | `module08.lesson09.example06.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [7](src/main/java/module08/lesson09/example07)           | `module08.lesson09.example07.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [8](src/main/java/module08/lesson09/example08)           | `module08.lesson09.example08.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [9](src/main/java/module08/lesson09/example09)           | `module08.lesson09.example09.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [10](src/main/java/module08/lesson09/example10)          | `module08.lesson09.example10.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [11](src/main/java/module08/lesson09/example11)          | `module08.lesson09.example11.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [12](src/main/java/module08/lesson09/example12)          | `module08.lesson09.example12.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [13](src/main/java/module08/lesson09/example13)          | `module08.lesson09.example13.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [14](src/main/java/module08/lesson09/example14)          | `module08.lesson09.example14.Main`          |
| 8.09 Module 8 Practice Solutions: Lessons 8.01–8.04   | [15](src/main/java/module08/lesson09/example15)          | `module08.lesson09.example15.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [1](src/main/java/module08/lesson10/example01)           | `module08.lesson10.example01.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [2](src/main/java/module08/lesson10/example02)           | `module08.lesson10.example02.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [3](src/main/java/module08/lesson10/example03)           | `module08.lesson10.example03.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [4](src/main/java/module08/lesson10/example04)           | `module08.lesson10.example04.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [5](src/main/java/module08/lesson10/example05)           | `module08.lesson10.example05.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [6](src/main/java/module08/lesson10/example06)           | `module08.lesson10.example06.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [7](src/main/java/module08/lesson10/example07)           | `module08.lesson10.example07.Main`          |
| 8.10 Module 8 Practice Solutions: Lessons 8.05–8.08   | [8](src/main/java/module08/lesson10/example08)           | `module08.lesson10.example08.Main`          |

### Module 9: File Handling and I/O

| Lesson                                              | Example                                                   | Main class                                       |
|-----------------------------------------------------|-----------------------------------------------------------|--------------------------------------------------|
| 9.01 Understanding Files, Paths, and Directories    | [1](src/main/java/module09/lesson01/example01)            | `module09.lesson01.example01.content.Main`       |
| 9.02 Reading Text Files                             | [1](src/main/java/module09/lesson02/example01)            | `module09.lesson02.example01.Main`               |
| 9.05 Managing Resources with Try-With-Resources     | [1](src/main/java/module09/lesson05/example01) (2 files)  | `module09.lesson05.example01.ClosingOrderDemo`   |
| 9.05 Managing Resources with Try-With-Resources     | [2](src/main/java/module09/lesson05/example02) (2 files)  | `module09.lesson05.example02.SuppressedDemo`     |
| 9.05 Managing Resources with Try-With-Resources     | [4](src/main/java/module09/lesson05/example04) (2 files)  | `module09.lesson05.example04.CourseSessionDemo`  |
| 9.06 File and Directory Operations                  | [1](src/main/java/module09/lesson06/example01)            | `module09.lesson06.example01.FileOperationsDemo` |
| 9.07 Designing a File-Based Repository              | [1](src/main/java/module09/lesson07/example01) (7 files)  | `module09.lesson07.example01.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [1](src/main/java/module09/lesson08/example01)            | `module09.lesson08.example01.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [2](src/main/java/module09/lesson08/example02)            | `module09.lesson08.example02.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [3](src/main/java/module09/lesson08/example03)            | `module09.lesson08.example03.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [4](src/main/java/module09/lesson08/example04)            | `module09.lesson08.example04.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [5](src/main/java/module09/lesson08/example05)            | `module09.lesson08.example05.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [6](src/main/java/module09/lesson08/example06)            | `module09.lesson08.example06.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [7](src/main/java/module09/lesson08/example07)            | `module09.lesson08.example07.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [8](src/main/java/module09/lesson08/example08)            | `module09.lesson08.example08.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [9](src/main/java/module09/lesson08/example09)            | `module09.lesson08.example09.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [10](src/main/java/module09/lesson08/example10)           | `module09.lesson08.example10.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [11](src/main/java/module09/lesson08/example11)           | `module09.lesson08.example11.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [12](src/main/java/module09/lesson08/example12)           | `module09.lesson08.example12.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [13](src/main/java/module09/lesson08/example13)           | `module09.lesson08.example13.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [14](src/main/java/module09/lesson08/example14)           | `module09.lesson08.example14.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [15](src/main/java/module09/lesson08/example15)           | `module09.lesson08.example15.Main`               |
| 9.08 Module 9 Practice Solutions: Lessons 9.01–9.04 | [16](src/main/java/module09/lesson08/example16)           | `module09.lesson08.example16.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [1](src/main/java/module09/lesson09/example01)            | `module09.lesson09.example01.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [2](src/main/java/module09/lesson09/example02)            | `module09.lesson09.example02.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [3](src/main/java/module09/lesson09/example03)            | `module09.lesson09.example03.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [4](src/main/java/module09/lesson09/example04)            | `module09.lesson09.example04.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [5](src/main/java/module09/lesson09/example05)            | `module09.lesson09.example05.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [6](src/main/java/module09/lesson09/example06)            | `module09.lesson09.example06.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [7](src/main/java/module09/lesson09/example07)            | `module09.lesson09.example07.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [8](src/main/java/module09/lesson09/example08)            | `module09.lesson09.example08.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [9](src/main/java/module09/lesson09/example09) (7 files)  | `module09.lesson09.example09.Main`               |
| 9.09 Module 9 Practice Solutions: Lessons 9.05–9.07 | [10](src/main/java/module09/lesson09/example10) (6 files) | `module09.lesson09.example10.Main`               |

### Module 10: Professional Java Practices

| Lesson                                                  | Example                                                   | Main class                                            |
|---------------------------------------------------------|-----------------------------------------------------------|-------------------------------------------------------|
| 10.01 Organizing Java Applications with Packages        | [1](src/main/java/module10/lesson01/example01)            | `module10.lesson01.example01.StaticImportDemo`        |
| 10.01 Organizing Java Applications with Packages        | [2](src/main/java/module10/lesson01/example02) (6 files)  | `module10.lesson01.example02.Main`                    |
| 10.02 Immutability and Defensive Programming            | [1](src/main/java/module10/lesson02/example01)            | `module10.lesson02.example01.CopyVsView`              |
| 10.02 Immutability and Defensive Programming            | [2](src/main/java/module10/lesson02/example02)            | `module10.lesson02.example02.ShallowArrayCopy`        |
| 10.02 Immutability and Defensive Programming            | [3](src/main/java/module10/lesson02/example03) (5 files)  | `module10.lesson02.example03.course.CourseDemo`       |
| 10.03 Equality, Hashing, and Object Contracts           | [1](src/main/java/module10/lesson03/example01) (2 files)  | `module10.lesson03.example01.course.CourseCodeDemo`   |
| 10.03 Equality, Hashing, and Object Contracts           | [2](src/main/java/module10/lesson03/example02)            | `module10.lesson03.example02.payment.SymmetryDemo`    |
| 10.03 Equality, Hashing, and Object Contracts           | [3](src/main/java/module10/lesson03/example03) (2 files)  | `module10.lesson03.example03.payment.MoneyDemo`       |
| 10.03 Equality, Hashing, and Object Contracts           | [4](src/main/java/module10/lesson03/example04)            | `module10.lesson03.example04.course.MutableKeyDemo`   |
| 10.03 Equality, Hashing, and Object Contracts           | [5](src/main/java/module10/lesson03/example05)            | `module10.lesson03.example05.course.OrderingDemo`     |
| 10.04 Choosing Data Models: Records, DTOs and Entities  | [1](src/main/java/module10/lesson04/example01)            | `module10.lesson04.example01.content.ArrayRecordDemo` |
| 10.04 Choosing Data Models: Records, DTOs and Entities  | [2](src/main/java/module10/lesson04/example02) (2 files)  | `module10.lesson04.example02.content.AttachmentDemo`  |
| 10.04 Choosing Data Models: Records, DTOs and Entities  | [3](src/main/java/module10/lesson04/example03) (5 files)  | `module10.lesson04.example03.course.SnapshotDemo`     |
| 10.06 Dependency Design and Composition                 | [1](src/main/java/module10/lesson06/example01) (8 files)  | `module10.lesson06.example01.Main`                    |
| 10.06 Dependency Design and Composition                 | [2](src/main/java/module10/lesson06/example02) (8 files)  | `module10.lesson06.example02.PublishCheck`            |
| 10.07 Refactoring a Small Java Application              | [1](src/main/java/module10/lesson07/example01) (10 files) | `module10.lesson07.example01.Main`                    |
| 10.08 Designing Clear APIs and Boundaries               | [1](src/main/java/module10/lesson08/example01)            | `module10.lesson08.example01.Main`                    |
| 10.09 Testing, Building and Debugging Java Code         | [1](src/main/java/module10/lesson09/example01) (2 files)  | `module10.lesson09.example01.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [1](src/main/java/module10/lesson10/example01)            | `module10.lesson10.example01.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [2](src/main/java/module10/lesson10/example02)            | `module10.lesson10.example02.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [3](src/main/java/module10/lesson10/example03)            | `module10.lesson10.example03.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [4](src/main/java/module10/lesson10/example04)            | `module10.lesson10.example04.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [5](src/main/java/module10/lesson10/example05)            | `module10.lesson10.example05.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [6](src/main/java/module10/lesson10/example06)            | `module10.lesson10.example06.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [7](src/main/java/module10/lesson10/example07)            | `module10.lesson10.example07.Main`                    |
| 10.10 Module 10 Practice Solutions: Lessons 10.01–10.04 | [8](src/main/java/module10/lesson10/example08)            | `module10.lesson10.example08.Main`                    |
| 10.11 Module 10 Practice Solutions: Lessons 10.05–10.09 | [1](src/main/java/module10/lesson11/example01)            | `module10.lesson11.example01.Main`                    |
| 10.11 Module 10 Practice Solutions: Lessons 10.05–10.09 | [2](src/main/java/module10/lesson11/example02)            | `module10.lesson11.example02.PublishCheck`            |
| 10.11 Module 10 Practice Solutions: Lessons 10.05–10.09 | [3](src/main/java/module10/lesson11/example03)            | `module10.lesson11.example03.Main`                    |
| 10.11 Module 10 Practice Solutions: Lessons 10.05–10.09 | [4](src/main/java/module10/lesson11/example04)            | `module10.lesson11.example04.Main`                    |

### Module 11: Final Project

| Lesson                                 | Example                                                   | Main class                                    |
|----------------------------------------|-----------------------------------------------------------|-----------------------------------------------|
| 11.02 Building the Domain Model        | [1](src/main/java/module11/lesson02/example01) (14 files) | `module11.lesson02.example01.DomainModelDemo` |
| 11.06 Building the Console Application | [1](src/main/java/module11/lesson06/example01) (34 files) | `module11.lesson06.example01.Main`            |

## Test Suites

JUnit 5 tests from the lessons. Run them all with `mvn test`, or one suite from IntelliJ IDEA (right-click its folder
under `src/test/java` and choose Run).

| Lesson                                                  | Test classes                               | Package                   |
|---------------------------------------------------------|--------------------------------------------|---------------------------|
| 10.09 Testing, Building and Debugging Java Code         | [3](src/test/java/module10/lesson09/tests) | `module10.lesson09.tests` |
| 10.11 Module 10 Practice Solutions: Lessons 10.05–10.09 | [4](src/test/java/module10/lesson11/tests) | `module10.lesson11.tests` |
| 11.10 Capstone Reference Tests                          | [8](src/test/java/module11/lesson10/tests) | `module11.lesson10.tests` |
