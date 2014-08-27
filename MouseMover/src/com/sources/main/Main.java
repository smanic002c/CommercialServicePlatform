package com.sources.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

        static final String[] testcases = new String[] {
            "'Tumblr' is an amazing app",
        "Tumblr is an amazing 'app'",
        "Tumblr is an 'amazing' app",
        "Tumblr is 'awesome' and 'amazing' ",
        "Tumblr's users' are disappointed ",
        "Tumblr's 'acquisition' complete but users' loyalty doubtful",
        "Successfully checked in content item 'ID_2883542'."
        };

    public static void main (String[] args) throws java.lang.Exception {
        Pattern p = Pattern.compile("'([^' ]+)'");
        for (String arg : testcases) {
            System.out.print("Input: "+arg+" -> Matches: ");
            Matcher m = p.matcher(arg);
            if (m.find()) {
                System.out.print(m.group());
                while (m.find()) System.out.print(", "+m.group());
                System.out.println();
            } else {
                System.out.println("NONE");
            }
        } 
    }
}