package cn.programtalk.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<=px)\\d");
        Matcher matcher = pattern.matcher("1px px2 ");
        while (matcher.find()) {
            System.out.println(matcher.groupCount());
        }
    }
}
