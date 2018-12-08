package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLesson {
    void RunLesson(){
        String text = "Dudos Memi hahahah kavo draka heydude";

        String pattern = "\\b\\w*d+\\w*\\b";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        if(m.find()){
            text = m.replaceAll("!$0!");
        }
        System.out.println(text);
    }
}
