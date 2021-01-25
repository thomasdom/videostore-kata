# VideoStore

The videostore example from Martin Fowler's Refactoring, and from Episode 3 of
[cleancoders.com](https://cleancoders.com), refactored following the best
practices of the industry.

## Author

Thomas Domingues <tdomingues@myges.fr>
3AL

## Statistics

- Number of code smells found: **3**
- Number of refactorings applied: **3**

## Description

| Detected code smell(s) | Refactoring technique(s) applied | Benefits |
|------------------------|----------------------------------|----------|
| Not using a build tool | Introduce Apache Maven as build tool for the project | Automatisable builds, dependency management, automatic test execution, and many more. |
| Bad formatting in all source files | Reformat files with IDE | Improve readability of the source code |
| Wrong order of symbols in classes | Reorder symbols in class according to best practices and IDE autocorrect feature | Improve readability of the source code |

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
