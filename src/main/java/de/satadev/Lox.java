package de.satadev;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Lox {

    static boolean hadError = false;

    public static void main(String[] args) throws IOException {

        if(args.length >1) {
            System.out.println("Usage jlox [script]");
            // https://man.freebsd.org/cgi/man.cgi?query=sysexits&apropos=0&sektion=0&manpath=FreeBSD+4.3-RELEASE&format=html
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);

        } else {
            runFromCommandLine();

        }
/**
        File file = new File("src/main/resources/Some.lox");

        if(file.exists()) {
            System.out.println("file exits");
            Scanner sc = new Scanner(file);


            while (sc.hasNext()) {
                boolean isComment = sc.nextLine().startsWith("//");
                if(isComment) {
                    System.out.println("ignore it");
                }
                System.out.println(sc.nextLine());
            }
        }
 **/

    }
    public static void runFile(String path) throws IOException {

        if (hadError) {
            System.exit(65);
        }
        byte[] readAll = Files.readAllBytes(Paths.get(path));
        run(new String(readAll, Charset.defaultCharset()));



    }
    public  static  void runFromCommandLine(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        bufferedReader.lines().forEach(stringBuilder::append);
        var loxCommand = stringBuilder.toString();
        run(loxCommand);
        hadError =false;
    }

    public static void run(String input ) {
        Scanner scanner = new Scanner(input);
        Stream<String> tokens = scanner.tokens();

        tokens.forEach(System.out::println);
    }

    static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where,
                               String message) {
        System.err.println(
                "[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }


}
