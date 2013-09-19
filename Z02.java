import java.util.regex.*;

public class Z02 {
	private static boolean validator (String text){

		try{
			Pattern pattern = Pattern.compile("(\\+|\\+ )\\d{1,3} \\(\\d{2,8}\\) \\d{1,6}\\-\\d{1,6}\\-\\d{1,6}");
			Matcher matcher = pattern.matcher(text);

			boolean result = false;

			if(matcher.matches()){
				result = true;
			}
			return result;

		} catch (PatternSyntaxException e) {
			System.out.println("Wrong regexp pattern");
			return false;
		}
	}

	private static  String replacer (String text){
		String num = null;
		try{

			if(validator(text)){
				Pattern pattern = Pattern.compile("\\D");
				Matcher matcher = pattern.matcher(text);

				while (matcher.find()){
					num = "+"+ matcher.replaceAll("");
				}
			}
			return num;

		} catch (PatternSyntaxException e) {
			System.out.println("Wrong regexp pattern");
			return num ;
		}

	}
	public static void main(String[] args) {

		System.out.println(replacer("+7 (353) 439-65-656"));
	}
}
