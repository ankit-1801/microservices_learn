import java.util.HashMap;
import java.util.Map;

public class Test {
public static void main(String[] args) {
	HashMap<String,String> mp = new HashMap<>();
	String A= "Aaxsa";
	String B= "Aacdxsa";
	String C= "Aaxdxda";
	String D= "Aaxsac";
	System.out.println(A.hashCode());
	System.out.println(B.hashCode());
	System.out.println(C.hashCode());
	System.out.println(D.hashCode());
	System.out.println(A.hashCode()&15);
	System.out.println(B.hashCode()&15);
	System.out.println(C.hashCode()&15);
	System.out.println(D.hashCode()&15);

}
}
