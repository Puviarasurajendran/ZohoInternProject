package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {
	
	
	public void numExtractorFromString(String str) {
		
		Pattern pattern= Pattern.compile("\\d+");
		Matcher match=pattern.matcher(str);
		
		while(match.find()) {
			String num=match.group();
		     System.out.println(num);
		}
	}
	
	public void removeExtraSpace(String input) {
		
		String ans= input.replaceAll("\\s{1,}", " ");
		System.out.println(ans);
		 
	}
	
	public  void extractNumber(String input) {
		
	        String pattern = "\\[([0-9]+)\\]";
	        Pattern regex = Pattern.compile(pattern);
	        Matcher matcher = regex.matcher(input);
	        
	        if (matcher.find()) {
	            System.out.println(matcher.group(1));
	        } else {
	           System.out.println("No Matches found");
	        }
	    }
	
	
	public  void extractRoles(String input) {
		
	        String pattern = "roles=\"([a-z0-9)]*)\"";
	        Pattern regex = Pattern.compile(pattern);
	        Matcher matcher = regex.matcher(input);
	        
	        while (matcher.find()) {
	            System.out.println(matcher.group(1));
	        } 
	    }
	
	
	public static void main(String[] args) {
		
		NumberExtractor ne= new NumberExtractor();
		
//		ne.numExtractorFromString("asdf123asdf456sdff");
//		
//		ne.removeExtraSpace("asdf asdf   asdf  asdf  a");
//		
//		ne.extractNumber("the string pattern[12345]pattern 67890");
		
		ne.extractRoles("profiles=\"test\" roles=\"testing\" profiles=\"testing\" \n"
				+ "profiles=\"test\" roles=\"ajith\"\n"
				+ "profiles=\"test\" roles=\"puvi1\"");
		
	}

}
