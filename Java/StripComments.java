public class StripComments {

	/*
	 * String commentPattern = "[" + String.join("", commentSymbols) + "].*?(\n|$)";
    
    return text.replaceAll(commentPattern, "$1").replaceAll("(?m)^(?!$)\\s+|\\s+$", "");
  }
	 */

	 /*
	  * String comment_pattern = "[" + String.join("", commentSymbols) + "].*?(\n|$)";
    String trim_pattern = "(?m)^\\s+|\\s+$";
    
    return text.replaceAll(comment_pattern, "$1").replaceAll(trim_pattern, "");
	  */
	public static String stripComments(String text, String[] commentSymbols) {
		text = text.replaceAll("[" + String.join("", commentSymbols) + "].*?(\n|$)", "$1");
		return text.replaceAll("(?m)^\\s+|\\s+$", "");
	}

	public static void main(String[] args) {

		System.out.println(stripComments( "apples, pears # and bananas\ngrapes\nbananas #apples", new String[] { "#", "!" } ));
	}
	
}