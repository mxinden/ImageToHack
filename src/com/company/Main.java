package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Please specify an imput image file and an output asm file.");
            System.exit(1);
        }


	    ImageToHack ith = new ImageToHack();

        /* Load Image */
        ith.readImage(args[0]);
        System.out.println("Image file successfully loaded");

        /* Build two dimensional boolean array of pictures */
        boolean [][]bol = ith.ImageToBinaryArray();
        System.out.println("Image successfully transfered to boolean array");

        /* Translate each 15+1 bit boolean block to one decimal number */
        int[][] finish = ith.BinaryArrayToDecimalArray(bol);
        System.out.println("Binary array successfully transformed to decimals");

        /* Write the decimal Array and the hack instructions to a file*/
        ith.writeDecimalToFile(finish, args[1]);
        System.out.println("Assembler file successfully written to file system");

    }

}
