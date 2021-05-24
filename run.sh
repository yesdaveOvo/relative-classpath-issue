#!/bin/sh -v

# Write a simple java program
cat <<EOF > Main.java
public class Main {
  public static void main(String[] args){
    System.out.println("Hello world!");
  }
}
EOF

# Compile it to target/
mkdir target && javac Main.java -d target

# Run it
java -classpath target/../target Main
