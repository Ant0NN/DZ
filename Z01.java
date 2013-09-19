import java.util.regex.*;

public class Z01 {
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

	public static void main(String[] args) {

		System.out.println(validator("+ 3 (475) 69-664-65"));
	}
}
