#!/usr/bin/env bash
# Gradescope Autograder Setup Script
# Base image: Ubuntu 22.04
# Runs ONCE when Docker image is built

set -euo pipefail

echo "=== Setting up Java 17 + Maven ==="

# Update package list
apt-get update -y

# Install Java 17 and Maven
apt-get install -y openjdk-17-jdk maven

# Set JAVA_HOME
echo "export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64" >> /etc/environment
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Verify installations
echo "=== Verifying installations ==="
java -version
mvn -version

echo "=== Setup complete ==="
