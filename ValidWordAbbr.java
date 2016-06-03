/*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

*/


//THe key to solove this problem
//They are not the same word.
//They both have equal lengths.
//They both share the same first and last letter.
public class ValidWordAbbr {
    HashMap<String, Integer> abbreviationDict;
    HashSet<String> dict;

    public ValidWordAbbr(String[] dictionary) {
        abbreviationDict = new HashMap<String, Integer>();
        dict = new HashSet<String>();
        for(String word:dictionary){
            String abb = abbreviate(word);
            dict.add(word);
            if(!abb.equals("")){
                int count = 0;
                if(abbreviationDict.get(abb) != null){
                    count = abbreviationDict.get(abb) ;
                }
               abbreviationDict.put(abb,count +1);
            }

        }
    }
    private String abbreviate(String word){
        if(word.length()> 2){
            int num = word.length() -2;
            char[] charWord = word.toCharArray();
            StringBuilder b = new StringBuilder("");
            b.append(charWord[0]);
            b.append(num);
            b.append(charWord[num+1]);
            return b.toString();
        }
        return "";
    }

    public boolean isUnique(String word) {
        Integer res = abbreviationDict.get(abbreviate(word));
        if(res != null){
            return (res == 1) & dict.contains(word);
        }
        return true;
    }
}
