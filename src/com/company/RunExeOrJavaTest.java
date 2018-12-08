package com.company;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class RunExeOrJavaTest {
    public static void main(String[] args) throws IOException {

        File exeFile = new File("AppTwo.exe");
        File jarFile = new File("AppTwo.jar");

        boolean isAppTwoExeFileExists = exeFile.exists();
        boolean isAppTwoJarFileExists = jarFile.exists();

        if (!isAppTwoExeFileExists && !isAppTwoJarFileExists) {
            JOptionPane.showMessageDialog(null, "ERROR: couldn\'t find executable Application TWO");
            System.exit(0);
        } else if (isAppTwoJarFileExists) {
            Process proc = Runtime.getRuntime().exec("java -jar AppTwo.jar");
        } else {
            Runtime.getRuntime().exec(exeFile.getAbsolutePath(), null, new File(exeFile.getAbsolutePath()).getParentFile());
        }
    }
}
