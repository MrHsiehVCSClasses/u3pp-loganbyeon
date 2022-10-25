package u3pp;

public class PalindromeTester {

    // //Takes a word
    // String str = "racecar", reverseStr = "";
        
    // //Getting the length of str
    // int strLength = str.length();

    // //Reversing str
    // for(int i = (strLength - 1); i >= 0; i--){
    //     reverseStr = reverseStr + str.charAt(i);
    // }

    // //If str is equal to the reversed str...
    // if(str.toLowerCase().equals(reverseStr.toLowerCase())){
    //     //The code will say str is a paindrome
    //     System.out.println(str + " is a Palindrome.");
    // }
    // else{
    //     //or that it's not a palindrome
    //     System.out.println(str + " is not a Palindrome.");
    // }

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i<j){
            //The character at the opposite index of the 
            //original str and the reversed str must be the same
            //or else it is not a palindrome
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}