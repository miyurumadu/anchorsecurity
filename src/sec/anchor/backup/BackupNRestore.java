/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.anchor.backup;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ChanakaDe
 */
public class BackupNRestore {

    public static void writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump anchor -h localhost -u root -pmysql -r " + path + "");
        int res = runtimeProcess.waitFor();
        if (res == 0) {
            JOptionPane.showMessageDialog(null, "Backup Completed!");
        } else {
            JOptionPane.showMessageDialog(null, "Backup writing Failed. . . ","Error",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(res);
    }

    public static void restoreBackup(String dbName, String dbUserName, String dbPassword, String path) throws IOException, InterruptedException {

        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName, "-e", " source " + path};

        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);

        int processComplete = runtimeProcess.waitFor();

        if (processComplete == 0) {
            JOptionPane.showMessageDialog(null, "Restore Complete");
        } else {
            JOptionPane.showMessageDialog(null, "Restore Faild","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
