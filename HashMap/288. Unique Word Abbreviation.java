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
public class ValidWordAbbr {
    HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();//用list作为值！！
    
    public ValidWordAbbr(String[] dictionary) {
        int size = dictionary.length;
        for(int i = 0; i < size; i++) {
            if(dictionary[i].length() <= 2) {
                if(!hm.containsKey(dictionary[i])) {
                    ArrayList<String> al = new ArrayList<String>();
                    al.add(dictionary[i]);
                    hm.put(dictionary[i], al);
                }
            } else {
                String tmp = dictionary[i].charAt(0) + "" + (dictionary[i].length() - 2) + "" + dictionary[i].charAt(dictionary[i].length() - 1);
                if(!hm.containsKey(tmp)) {
                    ArrayList<String> al = new ArrayList<String>();
                    al.add(dictionary[i]);
                    hm.put(tmp, al);
                } else {
                     ArrayList<String> al = hm.get(tmp);
                     if(!al.contains(dictionary[i])) {
                         al.add(dictionary[i]);
                     }
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String tmp;
        if(word.length() <= 2) {
            tmp = word;
        } else {
            tmp = word.charAt(0) + "" + (word.length() - 2) + "" + word.charAt(word.length() - 1);
        }
        if(hm.containsKey(tmp)) {
            ArrayList<String> al = hm.get(tmp);
            if(al.contains(word) && al.size() == 1) {//如果一个词的结构对应的词有多个词，则返回false，如果这个词对应的结构所对应的词只有一个，返回true
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");