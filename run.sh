#!/bin/bash

# A script to compile and run a single Java file containing JUnit 5 tests.
#
# Usage:
#   ./run_tests.sh YourJavaFile.java

# --- Configuration ---
# Exit immediately if a command exits with a non-zero status.
set -e

# --- 1. Input Validation ---
if [ -z "$1" ]; then
  echo "Error: No Java file provided."
  echo "Usage: $0 <YourJavaFile.java>"
  exit 1
fi

JAVA_FILE="$1"
# -f filePath to check if file exists?
if [ ! -f "$JAVA_FILE" ]; then
  echo "Error: File '$JAVA_FILE' not found."
  exit 1
fi

# --- 2. Find the JUnit JAR ---
# Automatically find the standalone JAR in the 'libs' directory.
JUNIT_JAR=$(find libs -name "junit-platform-console-standalone-*.jar" | head -n 1)

# -z to check if string is empty
if [ -z "$JUNIT_JAR" ]; then
  echo "Error: JUnit Standalone JAR not found in the 'libs/' directory."
  echo "Please download it and place it in 'libs/'."
  exit 1
fi

# --- 3. Set OS-specific Classpath Separator ---
# Windows uses ';', while macOS/Linux use ':'
if [[ "$OSTYPE" == "cygwin" ]] || [[ "$OSTYPE" == "msys" ]] || [[ "$OSTYPE" == "win32" ]]; then
  CP_SEPARATOR=";"
else
  CP_SEPARATOR=":"
fi

# --- 4. Clean and Compile ---
rm -f *.class

# The classpath includes the current directory '.' and the JUnit JAR.
javac -cp ".${CP_SEPARATOR}${JUNIT_JAR}" "$JAVA_FILE"
echo "--- Compilation successful. ---"

# --- 5. Run Tests ---

# Use the JUnit Console Launcher to scan the compiled classes in the current directory.
java -jar "$JUNIT_JAR" execute --class-path . \
--scan-class-path --disable-banner \
| sed '/Test run finished/,$d'

rm -f *.class
echo "--- Test run complete. ---"