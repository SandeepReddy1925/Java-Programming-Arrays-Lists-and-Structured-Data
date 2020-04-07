import edu.duke.FileResource;

public class CaesarCipher {

    String encrypt(String input,int key){

        StringBuilder encrypted=new StringBuilder(input);

        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_alphabets=alphabets.substring(key)+alphabets.substring(0,key);


        for(int i=0;i<encrypted.length();i++){

            char currChar=encrypted.charAt(i);
            char tempCurrChar=Character.toUpperCase(currChar);

            int index = alphabets.indexOf(tempCurrChar);
            if(index!=-1) {

                char newChar=shifted_alphabets.charAt(index);
                if(Character.isUpperCase(currChar)) {
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }

            }

        }

        return encrypted.toString();


    }
    public void testCaesar()
    {
        int key=22;
        FileResource fileResource=new FileResource();
        String message=fileResource.asString();
        String encrypted=encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public String encryptTwoKeys(String input,int key1,int key2)
    {
        StringBuilder encrypted=new StringBuilder(input);

        for(int i=0;i<encrypted.length();i++)
        {
            char currchar=encrypted.charAt(i);

            if(i%2==0) {
                String encryptedChar = encrypt(Character.toString(currchar),key1);
                encrypted.setCharAt(i,encryptedChar.toCharArray()[0]);
            }

            else {
                String encryptedChar = encrypt(Character.toString(currchar),key2);
                encrypted.setCharAt(i,encryptedChar.toCharArray()[0]);
            }

        }
        return encrypted.toString();
    }


    public static void main(String args[])
    {
        CaesarCipher cipher=new CaesarCipher();

        cipher.testCaesar();

       // String encrypted=cipher.encryptTwoKeys("First Legion", 23, 17);

        //System.out.println(encrypted);

    }
}
