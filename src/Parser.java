/********************************************************************************
 ∗ @file: Parser.java
 ∗ @description: This file processes the input text, makes calls to the BST class and writes the BST to the output file
 ∗ @author: Benton Phillips
 ∗ @date: September 25 , 2024
 *********∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*/

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

import java.io.*;
import java.util.Scanner;

public class Parser {
    private BST mybst = new BST();
    String result = "/Users/bentonphillips/Desktop/CSC 201/project-1-part-2-philbm22/src/result.txt";

    public Parser(String filename) throws FileNotFoundException {
        process(new File(filename));
        writeToFile(mybst.printString(), result);
    }

    public void process(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().strip();
            if (!line.isEmpty()) {
                String[] totalCommand = line.split(",");
                int MElevation = Integer.parseInt(totalCommand[1]);
                int FtElevation = Integer.parseInt(totalCommand[2]);
                System.out.println(totalCommand[0] + " " + totalCommand[1] + " " + totalCommand[2] + " " + totalCommand[3] + " " + totalCommand[4]);

                operate_BST(totalCommand, MElevation, FtElevation);
            }
        }
    }

    public void operate_BST(String[] command, int Melevation, int FtElevation) {
        Mountain myMountain = new Mountain(command[0], Melevation, FtElevation, command[3], command[4]);
        mybst.insert(myMountain);
    }

    public void writeToFile(String content, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}