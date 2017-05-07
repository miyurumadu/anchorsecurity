/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package componantControl;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author A.U.D.M.Gunasekara
 */
public class ValidateValues {
    public static boolean checkNumber(String s) {
        boolean isNumber = true;
        try {
            Long.parseLong(s);
            isNumber = true;
        } catch (Exception e) {
            isNumber = false;
        }
        return isNumber;
    }

    public static boolean checkName(String s) {
        boolean isName = true;
        try {
            Double.parseDouble(s);
            isName = false;
        } catch (Exception e) {
            isName = true;
        }
        return isName;
    }

    public static boolean checkNumberForCurrency(String s) {
        boolean isNumber = true;
        try {
            Double.parseDouble(s + "0");
            isNumber = true;
        } catch (Exception e) {
            isNumber = false;
        }
        return isNumber;
    }

    public static void validateTextFieldForNumber(JTextField txtContact) {
        try {
            String s = txtContact.getText();
            while (!checkNumber(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                s = s1;
            }
        } catch (Exception e) {
        }
    }

    public static void validateTextFieldForName(JTextField txtContact) {
        try {
            String s = txtContact.getText();
            while (!checkName(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                s = s1;
            }
        } catch (Exception e) {
        }
    }

    public static void validateTextFieldForNumberForCurrency(JTextField txtContact) {
        try {
            String s = txtContact.getText();
            while (!checkNumberForCurrency(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                s = s1;
            }
        } catch (Exception e) {
        }
    }

    public static boolean validateTextFieldForContactNumber(JTextField txtContact) {
        boolean ok=false;
        try {
            String s = txtContact.getText();
            while (!checkNumber(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                ok=false;

                s = s1;
            }
        } catch (Exception ex) {

        }
        String s2 = txtContact.getText();
        txtContact.setForeground(new java.awt.Color(255, 0, 0));
        ok=false;
        if(s2.length()==10){
            txtContact.setForeground(new java.awt.Color(0, 0, 0));
            ok=true;
        }else if (s2.length() > 10) {
            txtContact.setText(s2.substring(0, 10));
            txtContact.setForeground(new java.awt.Color(0, 0, 0));
            ok=true;
        }
        return ok;
    }

    public static void validateTextFieldForDigit(JTextField txtContact,int digit) {
        try {
            String s = txtContact.getText();
            while (!checkNumber(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                s = s1;
            }
        } catch (Exception ex) {
        }
        String s2 = txtContact.getText();
        if (s2.length() > digit) {
            txtContact.setText(s2.substring(0, digit));
        }
    }

    public static boolean validateTextFieldForNIC(JTextField txtContact) {
        boolean ok=false;
        txtContact.setForeground(new java.awt.Color(255, 0, 0));
        String s2 = txtContact.getText();

        if(s2.length() < 9){
            try {
                String s = s2;

                while (!checkNumber(s)) {
                    String s1 = s.substring(0, s.length() - 1);
                    txtContact.setForeground(new java.awt.Color(255, 0, 0));
                    ok=false;
                    txtContact.setText(s1);
                    
                    s = s1;
                }
            } catch (Exception ex) {
            }
        }else if(s2.length() == 9){
            txtContact.setForeground(new java.awt.Color(0, 0, 0));
            ok=true;
            txtContact.setText(s2+"V");
            
        }else{
            String s = s2.substring(0, 9);
            while (!checkNumber(s)) {
                    if(s.length()>1){
                        String s1 = s.substring(0, s.length() - 1);
//                        System.out.println(1);
    //                    txtContact.setText(s1);
                        s = s1;
                    }else{
                        s="";
                        break;
                    }
                }
            int i2=s.length();
            if(i2==9){
                txtContact.setForeground(new java.awt.Color(0, 0, 0));
                ok=true;
                txtContact.setText(s+"V");
                
            }else{
                txtContact.setForeground(new java.awt.Color(255, 0, 0));
                ok=false;
                txtContact.setText(s);
                
            }
        }
        return ok;

    }

    public static void validateTextFieldForNumberForCurrencyLimit(JTextField txtContact, int digit) {



        try {
            String s = txtContact.getText();

            s = filterminausorplus(s);

            while (!checkNumberForCurrency(s)) {
                String s1 = s.substring(0, s.length() - 1);
                txtContact.setText(s1);
                s = s1;
            }
            boolean b = s.contains(".");
            if (b) {
                int x1 = s.indexOf(".");
                String y1 = s.substring(0, x1);
                String y2 = s.substring(x1, s.length());
                if (y1.length() <= digit) {
                    String y3 = y1 + y2;
                    txtContact.setText(y3);
                } else {
                    while (s.length() > digit) {
                        String y4 = s.substring(0, s.length() - 1);
                        txtContact.setText(y4);
                        s = y4;
                    }
                }
            } else {
                if (s.length() <= digit) {
                    System.out.println(16);
                    txtContact.setText(s);
                } else {
                    while (s.length() > digit) {
                        String y5 = s.substring(0, s.length() - 1);
                        txtContact.setText(y5);
                        s = y5;
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static String convertStringValueForCurrency(String value) {
        double currencyD = Double.parseDouble(value);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        String currency = nf.format(currencyD);
        return currency;
    }
    
    public static String convertStringValueForCurrency(double value) {
        double currencyD = value;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        String currency = nf.format(currencyD);
        return currency;
    }
    
    public static void setTextFiealdForCurrency(JTextField txtContact){
        String s = txtContact.getText();
        if(s.isEmpty()){
            s="0";
        }
        s = chooceDigits(s, 10, 1, 2, 2);
        txtContact.setText(s);
    }
    
    public static String convertCurrencyValueToNumber(String val){
        return "no";
    }

    public static String chooceDigits(String value, int maxInt, int minInt, int maxFrac, int minFrac) {

        double val = Double.parseDouble(value);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(maxInt);
        nf.setMinimumIntegerDigits(minInt);
        nf.setMaximumFractionDigits(maxFrac);
        nf.setMinimumFractionDigits(minFrac);

        String vals = nf.format(val);


        return vals;
    }

    public static String chooceDigitsCurr(String value, int maxInt, int minInt, int maxFrac, int minFrac) {
        String vals = null;
        NumberFormat nf = null;
        double val = 0;
        if (checkNumberForCurrency(value)) {
            val = Double.parseDouble(value);
            nf = NumberFormat.getInstance();
            nf.setMaximumIntegerDigits(maxInt);
            nf.setMinimumIntegerDigits(minInt);
            nf.setMaximumFractionDigits(maxFrac);
            nf.setMinimumFractionDigits(minFrac);
            nf.setGroupingUsed(false);
            vals = nf.format(val);
        } else {
            vals = "0";
        }


        return vals;
    }

    public static String chooceDigitsgrop(String value, int maxInt, int minInt, int maxFrac, int minFrac) {
        double val = Double.parseDouble(value);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(maxInt);
        nf.setMinimumIntegerDigits(minInt);
        nf.setMaximumFractionDigits(maxFrac);
        nf.setMinimumFractionDigits(minFrac);
        nf.setGroupingUsed(false);

        String vals = nf.format(val);
        return vals;
    }
    
    public static String chooceDigitsgropForCurency(String value,int maxFrac, int minFrac) {
        double val = Double.parseDouble(value);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(maxFrac);
        nf.setMinimumFractionDigits(minFrac);
        nf.setGroupingUsed(true);

        String vals = nf.format(val);
        return vals;
    }
    
    public static void chooceDigitsgropForNumberTxtField(JTextField txtContact,int maxFrac, int minFrac) {
        String s = txtContact.getText();
        if(s.isEmpty()){
            s="0";
        }
        
        double val = Double.parseDouble(s);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(maxFrac);
        nf.setMinimumFractionDigits(minFrac);
        nf.setGroupingUsed(false);

        String vals = nf.format(val);
        txtContact.setText(vals);
    }

    public static void checkEMailAddres(JTextField tf) {
        String mail = tf.getText();
        String x = mail.substring(0, 1);
        x = x.toLowerCase();
        mail = x + mail.substring(1);
        tf.setText(mail);
        String s = "not mail";

        boolean o = mail.contains(".") && (!mail.contains(" ") && mail.contains("@"));

        if (o) {

            int a = mail.lastIndexOf(".");
            int l = mail.length();
            String com = mail.substring(a + 1, l);

            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(com);
            int i = 0;
            while (m.find()) {
                i++;
            }

            String notcom = mail.substring(0, a);

            boolean z = notcom.contains("@");

            String surche = null;
            String name = null;
            if (z) {

                boolean z2 = com.contains("@");

                int n = notcom.length();
                int b = notcom.lastIndexOf("@");
                surche = notcom.substring(b + 1, n);
                name = notcom.substring(0, b);

                boolean z3 = name.contains("@");
                boolean z4 = surche.contains(".");

                if (z2 || z3 || z4 || com.length() < 2 || surche.length() < 3 || name.length() < 3 || i > 0) {
                    s = "not mail";
                    tf.setText(s);
                    tf.requestFocus();
                    tf.selectAll();
                }

            } else {
                s = "not mail";
                tf.setText(s);
                tf.requestFocus();
                tf.selectAll();

            }
        } else {
            s = "not mail";
            tf.setText(s);
            tf.requestFocus();
            tf.selectAll();

        }

    }

    public static boolean checkEMailAddresFinal(JTextField tf) {
        boolean ok=false;
        String mail = tf.getText();
        tf.setForeground(new java.awt.Color(255, 0, 0));
        ok=false;
        tf.setText(mail);
        String s = "not mail";

        boolean o = mail.contains(".") && (!mail.contains(" ") && mail.contains("@"));

        if (o) {

            int a = mail.lastIndexOf(".");
            int l = mail.length();
            String com = mail.substring(a + 1, l);

            Pattern p = Pattern.compile("[0-9]");
            Matcher m = p.matcher(com);
            int i = 0;
            while (m.find()) {
                i++;
            }

            String notcom = mail.substring(0, a);

            boolean z = notcom.contains("@");

            String surche = null;
            String name = null;
            if (z) {

                boolean z2 = com.contains("@");

                int n = notcom.length();
                int b = notcom.lastIndexOf("@");
                surche = notcom.substring(b + 1, n);
                name = notcom.substring(0, b);

                boolean z3 = name.contains("@");
                boolean z4 = surche.contains(".");

                if (z2 || z3 || z4 || com.length() < 2 || surche.length() < 3 || name.length() < 3 || i > 0) {
                    s = "not mail";
                    tf.setForeground(new java.awt.Color(255, 0, 0));
                    ok=false;
//                    tf.setText(s);
//                    tf.requestFocus();
//                    tf.selectAll();
                }else{
                    tf.setForeground(new java.awt.Color(0, 0, 0));
                    ok=true;
                }

            } else {
                s = "not mail";
                tf.setForeground(new java.awt.Color(255, 0, 0));
                ok=false;
//                tf.setText(s);
//                tf.requestFocus();
//                tf.selectAll();

            }
        } else {
            s = "not mail";
            tf.setForeground(new java.awt.Color(255, 0, 0));
            ok=false;
//            tf.setText(s);
//            tf.requestFocus();
//            tf.selectAll();

        }
        return ok;

    }

    public static String filterName(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[0-9]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterNumberOnly(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                //System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }
    
    public static String filterCurrencyToNumberOnly(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9.]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                //System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterminausorplus(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[-+]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String AllValidate(String value, String validate) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[" + validate + "]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterNumber(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterRealName(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^a-zA-Z. ,'&:]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
//                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterRealNameWithNumbers(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^a-zA-Z0-9. ,'&:]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
//                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterDateTime(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9:-]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterDate(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9-]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterTime(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9:]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterDateYourChoose(String value,String caracter) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^0-9"+caracter+"]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }


    public static String filterWordCharacter(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^\\w]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterAddressWordCharacter(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^\\w,.()/;:'\"#@&*{}]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String filterMailCharacter(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("[^\\w.@]");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
//                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }

    public static String deleteSpaceCharacter(String value) {

        StringBuilder sb = new StringBuilder(value);

        Pattern p = Pattern.compile("\\s");
        Matcher n = p.matcher(value);
        int x = 0;
        while (n.find()) {
            x++;
        }

        for (int y = 0; y < x; y++) {
            Matcher m = p.matcher(sb);
            while (m.find()) {
//                System.out.println(m.start() + "  " + m.end());
                sb = sb.delete(m.start(), m.end());
                break;
            }
        }

        String out = new String(sb);

        return out;
    }  
}
