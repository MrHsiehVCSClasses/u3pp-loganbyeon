package u3pp;

public class PalindromeTester {

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
                System.out.print("Is the word a Palindrome? ");
                return false;
            }
            i++;
            j--;
        }
        System.out.print("Is the word a Palindrome? ");
        return true;
    }
}