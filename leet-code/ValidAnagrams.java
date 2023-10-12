public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26]; // 26 alphabets in english letters 
        if(s.length() != t.length())
            return false;

        for(char c : s.toCharArray())
            counter[c - 'a']++;
        
        for(char c: t.toCharArray())
            counter[c - 'a']--;


        for(int num : counter){
            if(num != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        ValidAnagrams va = new ValidAnagrams();

        System.out.println(va.isAnagram("anagram","ganamar"));
    }


}
