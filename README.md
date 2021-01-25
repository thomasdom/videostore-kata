# VideoStore

The videostore example from Martin Fowler's Refactoring, and from Episode 3 of
[cleancoders.com](https://cleancoders.com), refactored following the best
practices of the industry.

## Author

Thomas Domingues <tdomingues@myges.fr>
3AL

## Statistics

- Number of code smells found: **10**
- Number of refactorings applied: **13**

## Description

| Detected code smell(s) | Refactoring technique(s) applied | Benefits |
|------------------------|----------------------------------|----------|
| Not using a build tool | Introduce Apache Maven as build tool for the project | Automatisable builds, dependency management, automatic test execution, and many more. |
| Bad formatting in all source files | Reformat files with IDE | Improves readability of the source code |
| Wrong order of symbols in classes | Reorder symbols in class according to best practices and IDE autocorrect feature | Improves readability of the source code |
| Use of inappropriate data structure `Vector` in `Customer` class to store a list of rentals | Replace `Vector` by an [`ArrayList`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) | No forced synchronization on data structure, improved performance, improved memory usage, improved traversal method |
| Class fields not final without setters in `Customer` class | Make class fields final | Self-documented code, optimizations made by the compiler |
| Use of `Enumeration` for rentals traversal in `Customer` class | Replace enumeration to iteration | Shorter method names, able to remove elements while traversing, use of optimized for loop |
| Use of `while` instead of a `for` loop in `Customer` class | Change `while` by `for of` loop | Better readability of source code, uses Iterator under the hood (optimized for collection traversal) |
| Useless variable `each` in `Customer` class | Remove variable `each` | Improves readability | 
| Useless variable `rentals` in `Customer` class | Remove variable `rentals` | Improves readability | 
| `Rental` class should be used only when renting movies | Refactor method `addRental` in `Customer` to create a rental in this method; Rename method `addRental` to `rent`; Change parameter of `rent` method from `Rental` to `Movie`; Refactor tests | Better readability, better understanding of code, developer-friendly API |

## Installation

The application requires [Java 11](https://www.java.com/en/download/help/download_options.html)
to execute properly.

This project uses [Apache Maven](https://maven.apache.org/) as build tool. You
need to [install](https://maven.apache.org/download.cgi) it. Apache Maven will
be used throughout this documentation to install, configure and execute the
application.

First you need to install the dependencies using your favorite shell:

```shell
mvn install
```

Once dependencies are installed you can build the project:

```shell
mvn package
```

This command will generate an executable Java archive named
`VideoStore-<version>.jar` in the `target/` directory.

## Usage

To use the created JAR file, you can use the following command, replacing
`<version>` by the version number defined in [`pom.xml`](/pom.xml):

```shell
java -jar target/VideoStore-<version>.jar
```

Or if you prefer Apache Maven:

```shell
mvn exec:java
```

Note: Executing the application with Apache Maven results in a lot more output
information, which is not recommended when debugging.

## Contributing

See [CONTRIBUTING.md](/CONTRIBUTING.md).

## License

[MIT](https://choosealicense.com/licenses/mit/)
