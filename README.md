# NoobLab Graphics

NoobLab Graphics is a standalone Java library designed to replicate the interactive graphics functionality of the NoobLab online programming environment. This library provides a framework for drawing simple graphics using Java, with JavaFX as the default backend. Its extensible architecture also allows integration with alternative backends such as Swing (WIP) and OpenGL (WIP).

## Overview

The primary motivation behind the development of NoobLab Graphics is to provide students with a consistent learning experience. By replicating the graphical rendering capabilities of the original NoobLab platform, this library enables learners to develop Java applications within their preferred IDE while maintaining the same educational environment.

All features of the original NoobLab graphics implementation are preserved in this library and are expected to work exactly as in the original environment.

## Features

- **Compatibility with NoobLab:**  
  This library reimplements NoobLab's in-browser graphics API, allowing students to continue their learning seamlessly in local Java environments using the same interface and paradigms.

- **Cross-Platform Rendering:**  
  Utilizes JavaFX by default for rendering graphics. The library’s architecture permits the incorporation of other rendering backends (e.g., Swing, OpenGL) through an adapter pattern, promoting modularity and extensibility.

- **Unit Testing:**  
  A suite of JUnit tests is provided, covering various components such as graphic elements, style parsing, and state management.

## Installation

### Maven Dependency

NoobLab Graphics is available via Maven. To add it as a dependency in your Maven project, include the following snippet in your `pom.xml`:

```xml
<dependency>
    <groupId>com.nooblab</groupId>
    <artifactId>nooblab-graphics</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Add repository (remember to authenticate with Github):
```xml
<repositories>
  <repository>
    <id>nooblab-graphics-gh</id>
    <name>Nooblab Graphics</name>
    <url>https://maven.pkg.github.com/samuelbsource/nooblab-graphics</url>
  </repository>
</repositories>
```

### Additional Dependencies

Since NoobLab Graphics uses JavaFX as its default backend, it is imperative that your project includes JavaFX dependencies. Failure to do so will result in the library being unable to render graphics. Alternatively, if another backend is preferred (e.g., Swing or OpenGL), ensure that the appropriate libraries are available in your project’s dependency list.

For example:
```xml
<dependency>
  <groupId>org.openjfx</groupId>
  <artifactId>javafx-controls</artifactId>
  <version>25-ea+6</version>
</dependency>
```

## Usage

After adding the library and the necessary backend dependencies to your Maven project, students can use the library in exactly the same way they would within the NoobLab environment. All graphical operations are performed by calling the relevant static methods of the `Graphics` class.

No additional initialization is required. The library automatically detects and initializes the appropriate backend as soon as it is needed.

## Motivation

The primary motivation behind NoobLab Graphics is to allow students to write and run graphical Java programs in their own preferred IDEs. While NoobLab provides a helpful beginner environment, it is not a tool students will encounter in real-world software development. This library bridges that gap by offering a familiar interface outside of the browser, helping students gain experience with real development tools and workflows early in their learning journey.

## License

NoobLab Graphics is released under the [Apache 2.0 License](LICENSE), ensuring that it remains freely available for academic and commercial use.

---

Feel free to contribute to the project, or report any issues.

