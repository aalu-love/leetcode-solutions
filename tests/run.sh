#!/usr/bin/env bash
# Usage: bash tests/run.sh "<solution file>" <CasesClass> <methodName>
# Example: bash tests/run.sh "48. Rotate Image.java" RotateImageCases rotate
cd "$(dirname "$0")/.." || exit 1

out="$(mktemp -d)"
javac -d "$out" "$1" tests/TestCase.java tests/Executor.java "tests/cases/$2.java" || exit 1
java -cp "$out" Executor "$2" "$3"
