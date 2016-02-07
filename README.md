# code-challenge-boilerplate
Abstracts Stdin and Stderr so that code can be easily tested locally before submitting code to programmer challenge websites.


# Motivation
Writing code on code challenge websites like HackerRank is slow and tedious.  Coders can't write a collection of tests, use a debugger, or quickly run code.  The obvious solution to these problems is to write the code locally with an IDE, but this is difficult because these challenge websites use stdin and stdout to interact with developer code.  This project alleviates this by adding a lay of abstraction over top of the streams so that developers can write unit tests for their code.                                         

# How to Use
Simply implement the run method of the Runner class to solve the coding challenge, write tests, and then copy-paste all of the code in the Solution.java file into the code challenge website.