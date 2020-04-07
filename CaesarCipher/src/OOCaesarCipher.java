public class OOCaesarCipher {


    private String alphabets;
    private String shifted_alphabets;
    private int mainKey;


    public OOCaesarCipher(int key)
    {
        alphabets="abcdefghijklmnopqrstuvwxyz";
        shifted_alphabets=alphabets.substring(key)+alphabets.substring(0,key);
        mainKey=key;
    }

    String encrypt(String input){

        StringBuilder encrypted=new StringBuilder(input);

        for(int i=0;i<encrypted.length();i++){

            char currChar=encrypted.charAt(i);
            char tempCurrChar=Character.toLowerCase(currChar);

            int index = alphabets.indexOf(tempCurrChar);
            if(index!=-1) {

                char newChar=shifted_alphabets.charAt(index);
                if(Character.isLowerCase(currChar)) {
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    encrypted.setCharAt(i,Character.toUpperCase(newChar));
                }

            }

        }

        return encrypted.toString();


    }

    public String decrypt(String input)
    {
        OOCaesarCipher ocipher1=new OOCaesarCipher(26-mainKey);

        String decypted=ocipher1.encrypt(input);

        return decypted;
    }






}
