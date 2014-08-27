package com.sources.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sources.constants.Constants;

public class ExtractText {

	private static final String tagValue = "Successfully checked in content item 'asdfasfdsafads542'.";
	public static void main(String[] args) {
		final String methodName = "main";
		System.out.println(Constants.START + methodName );
		System.out.println("output: "+ extractTextWithinQuotes(tagValue));
		System.out.println(Constants.END + methodName );
	}
	
	private static String extractTextWithinQuotes(String tagValue) {
		String capturedContent = "";
		Pattern p = Pattern.compile("'([^' ]+)'");
        Matcher m = p.matcher(tagValue);
        if (m.find()) {
            capturedContent = m.group();
        } else {
            System.out.println("NONE");
        }
        capturedContent = capturedContent.replaceAll("'", "");
        return capturedContent;
	}

}
