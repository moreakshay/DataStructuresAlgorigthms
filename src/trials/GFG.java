// Java implementation of the approach
import java.util.ArrayList;

public class GFG {

    // Function that returns true if string s
    // is present in the Arraylist
    static boolean isPresent(String s, ArrayList<String> Res)
    {

        // If present then return true
        for (String str : Res) {

            if (str.equals(s))
                return true;
        }

        // Not present
        return false;
    }

    // Function to return an ArrayList containg
    // all the distinct permutations of the string
    static ArrayList<String> distinctPermute(String str)
    {

        // If string is empty
        if (str.length() == 0) {

            // Return an empty arraylist
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        // Take first character of str
        char ch = str.charAt(0);

        // Rest of the string after excluding
        // the first character
        String restStr = str.substring(1);

        // Recurvise call
        ArrayList<String> prevRes = distinctPermute(restStr);

        // Store the generated sequence into
        // the resultant Arraylist
        ArrayList<String> Res = new ArrayList<>();
        for (String s : prevRes) {
            for (int i = 0; i <= s.length(); i++) {
//                System.out.println("Source String: " + str );
//                System.out.println("Previous: " + prevRes.toString());
//                System.out.println("String:- '" + s + "' substring(0,1): '" + s.substring(0, i) + "' ch: '" + ch + "' substring(rest): '" + s.substring(i) + "'");
                String f = s.substring(0, i) + ch + s.substring(i);

                // If the generated string is not
                // already present in the Arraylist
                if (!isPresent(f, Res))

                    // Add the generated string to the Arraylist
                    Res.add(f);
            }
        }

        // Return the resultant arraylist
        return Res;
    }

    // Driver code
    public static void main(String[] args)
    {
        String s = "abbb";
        System.out.println(distinctPermute(s));
    }
}
