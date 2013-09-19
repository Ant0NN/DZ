import java.util.regex.*;

public class Z03 {
	private static boolean validator (String text){

		try{
			Pattern pattern = Pattern.compile("((\\$|€)\\d{1,}(\\.|,)\\d{1,2})|\\$|€\\d{1,}");
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

	private static double exchange (String text){
		double d = 0;
		final double EURO = 43.15;
		final double DOLLAR = 32.32;

		if(validator(text)){

			char t = text.charAt(0);
			d = Double.parseDouble(text.replaceAll("\\$|€", "").replaceAll(",", "."));
			if(t == '€'){
				System.out.println("Euro "+d);
				d *= EURO;

			} else {
				System.out.println("Dollar "+d);
				d *= DOLLAR;
			}

			d = ((double)Math.round(d*100)/100);
		}
		return d;
	}


	public static void main(String[] args) {

		System.out.println("Ruble "+exchange("$10.55"));
	}
}
