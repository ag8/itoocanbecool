package org.ag8.itoocanbecool;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
git add .
git commit -m "Another commit to look cool"
git push
 */

public class Main {
    static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        makeFileCooler();

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\Users\\Andrew\\workspace\\f\\itoocanbecool\" && git add . && git commit -m \"Another commit to look cool\" && git push");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

    private static void makeFileCooler() throws IOException {
        // Decide whether to append or start over
        int k = randInt(0, 1000);

        if (k == 1) {
            PrintWriter writer = new PrintWriter("cool.txt");
            writer.print("");
            writer.close();
        } else {
            FileUtils.writeStringToFile(new File("cool.txt"), "a", true);
        }
    }

    // http://stackoverflow.com/a/363692/2930268
    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
