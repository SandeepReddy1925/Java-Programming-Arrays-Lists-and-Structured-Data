import java.io.*;
import java.lang.*;
public class WordPlay {
    public boolean isVowel(char ch)
    {
        char ch1=Character.toLowerCase(ch);
        if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u')
            return true;
        else
            return false;
    }
    public void testIsVowel()
    {
        boolean vowel=isVowel('a');

        if(vowel)
           System.out.println("it is vowel");
        else
            System.out.println("nont an vowel");

        boolean vowel1=isVowel('I');

        if(vowel)
            System.out.println("it is vowel");
        else
            System.out.println("nont an vowel");
    }
    public String replaceVowels(String phrase,char ch)
    {
        StringBuilder oldphrase=new StringBuilder(phrase);

        for(int i=0;i<oldphrase.length();i++)
        {
            if(isVowel(oldphrase.charAt(i)))
                oldphrase.setCharAt(i,ch);
        }

        return oldphrase.toString();
    }

    public String emphasize(String phrase,char ch)
    {
        StringBuilder oldPhrase=new StringBuilder(phrase);

        for(int i=0;i<oldPhrase.length();i++)
        {
            if(oldPhrase.charAt(i)==ch)
                if((i+1)%2==0)
                    oldPhrase.setCharAt(i,'+');
                else
                    oldPhrase.setCharAt(i,'*');
        }

        return oldPhrase.toString();
    }


    public static void main(String args[])
    {

        WordPlay word=new WordPlay();

        //word.testIsVowel();

        String newphrase=word.replaceVowels("hello wOrld",'%');
        System.out.println(newphrase);

        newphrase=word.emphasize("dna ctgaaactga",'a');
        System.out.println(newphrase);

        newphrase=word.emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(newphrase);

    }
}
