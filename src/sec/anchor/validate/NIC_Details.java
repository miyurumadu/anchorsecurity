/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.anchor.validate;

/**
 *
 * @author Miyuru Madusanka
 */
public class NIC_Details {

    String id;
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public NIC_Details(String id) {
        this.id = id;
    }

    public int getYear() {
        if (id.length() > 10) {
            return (Integer.parseInt(id.substring(0, 4)));
        } else {
            return (1900 + Integer.parseInt(id.substring(0, 2)));
        }
    }

    public int getDays() {
        int d;
        if (id.length() > 10) {
            d = Integer.parseInt(id.substring(4, 7));
        } else {
            d = Integer.parseInt(id.substring(2, 5));
        }
        if (d > 500) {
            return (d - 500);
        } else {
            return d;
        }
    }

    public String setMonth() {
        int mo = 0, da = 0;
        int days = getDays();

        for (int i = 0; i < month.length; i++) {
            if (days < month[i]) {
                mo = i + 1;
                da = days;
                break;
            } else {
                days = days - month[i];
            }
        }
        return mo + "-" + da;

    }

    public String getSex() {
        String M = "Male", F = "Female";
        int d = Integer.parseInt(id.substring(2, 5));
        if (d > 500) {
            return F;
        } else {
            return M;
        }
    }

    public static String birthday(String id) {
        NIC_Details N = new NIC_Details(id);
        return N.getYear() + "-" + N.setMonth();
    }
}
