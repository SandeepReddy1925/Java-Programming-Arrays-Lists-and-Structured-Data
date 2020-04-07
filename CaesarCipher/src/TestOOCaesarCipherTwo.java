import edu.duke.FileResource;

public class TestOOCaesarCipherTwo {

    public String halfOfString(String message,int start)
    {
        String newString="";

        for(int i=start;i<message.length();i++) {
            newString = newString + message.charAt(i);
            i++;
        }

        return newString;

    }
    public int[] countLetters(String encryptedMessage) {
        int[] lettersCount = new int[26];

        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < encryptedMessage.length(); i++) {

            char currchar = encryptedMessage.charAt(i);
            char tempChar=Character.toLowerCase(currchar);

            int index = alphabets.indexOf(tempChar);

            if (index != -1)
                lettersCount[index]++;

        }

        return lettersCount;
    }


    int indexOfMax(int[] counts){

        int maxValue = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxValue]) {

                maxValue = i;


            }
        }
        return maxValue;
    }

    public void simpleTests()
    {
        FileResource fileResource=new FileResource();

        String plaintext=fileResource.asString();

        OOCaesarCipherTwo oocipher=new OOCaesarCipherTwo(17,3);

        String encrypted=oocipher.encrypt(plaintext);

        System.out.println("encrypted String is \n"+encrypted);

       breakCaesarCipher(encrypted);

        String decrypted=oocipher.decrypt(encrypted);

        System.out.println("Decrypted string is \n"+decrypted);
    }

    public  void breakCaesarCipher(String input)
    {
        String s1=halfOfString(input,0);
        String s2=halfOfString(input,1);

        int[] freqs1=countLetters(s1);
        int[] freqs2=countLetters(s2);

        int maxIndex1=indexOfMax(freqs1);
        int maxIndex2=indexOfMax(freqs2);

        int dkey1=maxIndex1-4;
        if(maxIndex1<4)
            dkey1=26-(4-maxIndex1);

        int dkey2=maxIndex2-4;
        if(maxIndex2<4)
            dkey2=26-(4-maxIndex2);

        OOCaesarCipherTwo ooCaesarCipherTwo=new OOCaesarCipherTwo(dkey1,dkey2);

        String decrypted=ooCaesarCipherTwo.decrypt(input);

        System.out.println("decrpted string using brakceasarcipher is "+decrypted);
    }


    public static void main(String args[])
    {
        TestOOCaesarCipherTwo testcipher=new TestOOCaesarCipherTwo();

        testcipher.simpleTests();


    }

}
