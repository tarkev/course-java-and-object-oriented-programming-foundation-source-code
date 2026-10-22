#!/usr/bin/env bash
# Compile all examples with the JDK and run one of them.
# Usage: ./run.sh module01.lesson17.example01.Main
set -euo pipefail
cd "$(dirname "$0")"
if [ $# -lt 1 ]; then
    echo "Usage: ./run.sh <main class>, for example: ./run.sh module01.lesson17.example01.Main"
    echo "See README.md for every example's main class."
    exit 1
fi
mkdir -p target/classes
find src/main/java -name '*.java' > target/sources.txt
javac --release 21 -d target/classes @target/sources.txt
java -cp target/classes "$@"
