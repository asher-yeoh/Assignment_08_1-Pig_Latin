import java.util.Arrays;

import sun.jvm.hotspot.oops.java_lang_Class;

/**
 * PigLatin
 */
public class PigLatin {
    static String convert(String word){
        
        char[] wordArr = word.toCharArray();

        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

        String firstPhrase = "";
        String lastPhrase = "ay";
        String tempPhrase = "";
        String newPhrase = "";
        
        for (int i = 0; i < wordArr.length; i++) {
            
            int lastIndex = wordArr.length - 1;

            Character currentChar = wordArr[i];
            boolean isVowel = Arrays.asList(vowels).contains(currentChar);

            if (isVowel) {
                if (i == 0) {
                    newPhrase = word;
                    
                    break;
                }

                else {

                    for (int j = 0; j < i; j++) {
                        firstPhrase += wordArr[j];
                    }

                    for (int k = i; k < wordArr.length; k++) {
                        tempPhrase += wordArr[k];
                    }

                    newPhrase += tempPhrase + firstPhrase + lastPhrase;
                
                    break;
                }
            }

            if (i == lastIndex) {
                newPhrase = word + lastPhrase;
               
                break;
            }

        }

        System.out.println("--------------------");
        System.out.println(newPhrase);
        return newPhrase;
        
    }

    public static void main(String[] args){
        System.out.println(convert("art").equals("art"));
        System.out.println(convert("vowel").equals("owelvay"));
        System.out.println(convert("nginx").equals("inxngay"));
        System.out.println(convert("hello").equals("ellohay"));
        System.out.println(convert("Dr").equals("Dray"));
        System.out.println(convert("Spyo").equals("oSpyay"));
    }
}