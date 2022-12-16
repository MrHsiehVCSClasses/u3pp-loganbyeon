package u3pp;

public class PalindromeTester {

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        // change all letters to lower case for words like rAceCaR
        s = s.toLowerCase();
        
        int half = s.length() / 2;

        for(int i = 0; i < half; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
            // need -1 because i starts at 0 and the lenght it +1 of the index
                return false;
            }
        }
        return true;
    }
}
