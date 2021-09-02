package playGround;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hexaPractice {

	
	public static String hexaModule(String param) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < param.length(); i++) {
			sb.append(String.format("0x%02X", (int)param.charAt(i)));
		}
		
		return sb.toString();
	}
	
	public static String hexaRecovery(String param) {
		
		
		String convertValue = "";
		Pattern p = Pattern.compile("(0x([a-fA-F0-9]{2}([a-fA-F0-9]{2})?))");
	    Matcher m = p.matcher(param);

	    StringBuffer sb = new StringBuffer();
	    int hashCode = 0;
	    while( m.find() ) {
	        hashCode = Integer.decode("0x" + m.group(2));
	        m.appendReplacement(sb, new String(Character.toChars(hashCode)));
	    }
	    m.appendTail(sb);
	    convertValue = sb.toString();

		System.out.println("GPKIError Page convert : " + convertValue);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		
		String a = "tran_id||tran_adm@orderby=dttm_ne";
		
		String stringToHexa = hexaModule(a);
		System.out.println(stringToHexa);
		System.out.println(stringToHexa.length());
		
		System.out.println();
		
		String hexaTostring = hexaRecovery(stringToHexa);
		System.out.println(hexaTostring);
		System.out.println(hexaTostring.length());
		
	}
}
