import java.io.File;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {

        StringBuilder slicedString=new StringBuilder();

        for(int i=whichSlice;i<message.length();i+=totalSlices)
        {

            slicedString.append(message.charAt(i));

        }

        return slicedString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {

        CaesarCracker cracker=new CaesarCracker(mostCommon);

        int[] key = new int[klength];

        String[] encryptedParts=new String[klength];

        for(int i=0;i<key.length;i++)
        {
            encryptedParts[i]=sliceString(encrypted,i,klength);

            key[i]=cracker.getKey(encryptedParts[i]);


        }

        return key;
    }

    public char mostCommonCharIn(HashSet<String> dict) {

        CaesarCracker cracker=new CaesarCracker();
        int[] charCount=new int[26];

        String alph = "abcdefghijklmnopqrstuvwxyz";

        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                int idx = alph.indexOf(Character.toLowerCase(word.charAt(i)));

                if (idx != -1)
                    charCount[idx]++;

            }

        }

       int maxIndex=cracker.maxIndex(charCount);

        return alph.charAt(maxIndex);
    }

    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>>languages)
    {
       int maxCount=0;
       String originalDecryption="";
       String textlanguage="";

        for(String language:languages.keySet())
        {

            String decrypted=breakForLanguage(encrypted,languages.get(language));

            int countwords=+countWords(decrypted,languages.get(language));

            if(countwords>maxCount)
            {
                maxCount=countwords;
                originalDecryption=decrypted;
                textlanguage=language;
            }

        }

        System.out.println("Language is "+textlanguage+"\n"+originalDecryption);


    }


    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String>dictionary=new HashSet<String>();

        for(String word:fr.lines())
        {
            dictionary.add(word.toLowerCase());
        }

        return dictionary;
    }

    public int countWords(String message,HashSet<String>dict)
    {
        int count=0;

        for(String word:message.split("\\W+")){

            word=word.toLowerCase();

            if(dict.contains(word))
                count++;
        }

        return count;
    }

    public String breakForLanguage(String encrypted,HashSet<String>dict)
    {
        int[] realWordCount=new int[101];

        int maxCount=0;
        int maxIndex=0;

        String originalDecryption="";

        char mostcommonChar=mostCommonCharIn(dict);

        for(int i=1;i<=100;i++)
        {
            int[] key=tryKeyLength(encrypted,i,mostcommonChar);

            VigenereCipher cipher=new VigenereCipher(key);

            String decrypted=cipher.decrypt(encrypted);

            realWordCount[i]=countWords(decrypted,dict);

            if(realWordCount[i]>maxCount)
            {
                maxCount=realWordCount[i];
                originalDecryption=decrypted;
                maxIndex=i;
            }

        }

        return originalDecryption;


    }

    public void breakVigenere () {
        FileResource file=new FileResource();

        String encrypted=file.asString();

        HashMap<String,HashSet<String>>languages=new HashMap<String, HashSet<String>>();

        DirectoryResource directoryResource=new DirectoryResource();

        for(File f:directoryResource.selectedFiles())
        {

            String filename=f.getName();

            FileResource fileResource=new FileResource(f);

            HashSet<String> dict=readDictionary(fileResource);

            languages.put(filename,dict);

            System.out.println("Completed reading "+filename+" dictionary");
        }

        breakForAllLangs(encrypted,languages);


    }

    public static void main(String args[])
    {
        VigenereBreaker breaker=new VigenereBreaker();

        breaker.breakVigenere();


    }
    
}
