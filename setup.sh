#!/usr/bin/env bash

# Gradescope autograder setup script
# Runs once when the autograder Docker image is built

set -e

apt-get update
apt-get install -y openjdk-17-jdk maven

# Verify installations
java -version
mvn -version

echo "Setup complete: Java 17 and Maven installed"
