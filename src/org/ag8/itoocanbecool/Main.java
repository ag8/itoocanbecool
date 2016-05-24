package org.ag8.itoocanbecool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
git add .
git commit -m "Another commit to look cool"
git push
 */

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\Users\\Andrew\\workspace\\f\\itoocanbecool\" && git status");
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
}
