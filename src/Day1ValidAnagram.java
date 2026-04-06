import java.util.HashMap;
import java.util.Scanner;

public class Day1ValidAnagram {
/*
Valid Anagram
Problem Statement - You are given two Strings. You have to tell whether these two strings are Valid Anagram or not?
Eg:- "SILENT" & "LISTEN" are Anagrams
     "HEART" & "EARTH" are Anagrams
     "TALENT" & "LATENT" are Anagrams
     Anagram - Rearranging the letters of one String can form the other String
*/

    private static boolean isValidAnagram(String s1, String s2){
    /*
    Time Complexity:-
    One Loop over Strings of length n:- O(n)
    One Loop over HashMap:- O(n)
    Total O(n+n) ~ O(n)
    Space Complexity:-
    2 HashMaps that may contains max size of n(length of String)
    O(n) + O(n) = O(2n) ~ O(n)
    */
    if(s1.length()!=s2.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap();
        HashMap<Character,Integer> map2 = new HashMap();
        for(int i=0; i<s1.length(); i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }
        for(char ch: map1.keySet()){
            int freq = map1.get(ch);
            if(!(map2.containsKey(ch))) return false;
            if(map2.get(ch)!=freq) return false;
        }
        return true;
    }
    static void main() {
        Scanner sc =  new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        boolean result = isValidAnagram(s1,s2);
        System.out.println("Valid Anagrams: " + result);
    }
}
