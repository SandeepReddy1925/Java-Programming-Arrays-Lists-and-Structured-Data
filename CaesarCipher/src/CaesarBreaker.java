import edu.duke.FileResource;

public class CaesarBreaker {

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

    public void decrypt(String encrypted) {

        CaesarCipher cipher = new CaesarCipher();

        int[] freqs = countLetters(encrypted);

        int maxIndex = indexOfMax(freqs);
        System.out
                .println(maxIndex);

        int decryptionKey = maxIndex - 4;

        if (maxIndex < 4)
            decryptionKey = 26 - (4 - maxIndex);

        String decrptedMessage = cipher.encrypt(encrypted, 26 - decryptionKey);

        System.out.println("decrypted text is "+decrptedMessage);

    }


    public void  decryptTwoStrings(String encrypted)
    {
        CaesarCipher cipher=new CaesarCipher();

        String frstprtofEncrypted=halfOfString(encrypted,0);
        System.out.println(frstprtofEncrypted);
        String scndprtofEncrypted=halfOfString(encrypted,1);
        System.out.println(scndprtofEncrypted);

        int key1=getKey(frstprtofEncrypted);
        int key2=getKey(scndprtofEncrypted);

        System.out.println("two keys found "+key1+" "+key2);

        int dkey1=key1-4;
        if(key1<4)
            dkey1=26-(4-key1);

        int dkey2=key2-4;
        if(key2<4)
            dkey2=26-(4-key2);


        String decrpted=cipher.encryptTwoKeys(encrypted,26-dkey1,26-dkey2);

        System.out.println(" decrpted message is "+decrpted);
    }
    public void testDecyrpt()
    {

        FileResource fileResource=new FileResource();

        String encrypted=fileResource.asString();


        decrypt(encrypted);




    }

    public String halfOfString(String message,int start)
    {
        String newString="";

        for(int i=start;i<message.length();i++) {
            newString = newString + message.charAt(i);
            i++;
        }

        return newString;

    }

    int getKey(String s){
        int[] counts=new int[26];

        counts=countLetters(s);

        int maxIndex=indexOfMax(counts);

        return maxIndex;

    }



    public static void main(String args[])
    {
        CaesarBreaker breaker=new CaesarBreaker();

       //breaker.testDecyrpt();

        FileResource fileResource=new FileResource();
        String encrpted=fileResource.asString();

        breaker.decryptTwoStrings(encrpted);

    }

}
