import edu.duke.FileResource;

public class TestOOCaesarCipher {
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

    public void breakCaesarCipher(String input)
    {
        int[] freqs=countLetters(input);

        int maxIndex=indexOfMax(freqs);

        int dkey=maxIndex-4;

        if(maxIndex<4)
            dkey=26-(4-maxIndex);

        OOCaesarCipher breakcipher=new OOCaesarCipher(dkey);

        String decrypted=breakcipher.decrypt(input);

        System.out.println("deccrypted String is "+decrypted);
    }

    public void simpleTests()
    {
        OOCaesarCipher ocipher=new OOCaesarCipher(18);

        FileResource fileResource=new FileResource();
        String plaintext=fileResource.asString();

        String encrypted=ocipher.encrypt(plaintext);

        System.out.println("encrypted string is \n"+encrypted);

        breakCaesarCipher(encrypted);

        String decrypted=ocipher.decrypt(encrypted);

        System.out.println("decrypted string is  \n"+decrypted);

    }

    public static void main(String args[])
    {
        TestOOCaesarCipher ooctest=new TestOOCaesarCipher();

        ooctest.simpleTests();
    }
}
