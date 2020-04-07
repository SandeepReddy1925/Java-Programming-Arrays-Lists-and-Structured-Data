public class OOCaesarCipherTwo {

    private String alphabet;
    private String shifted_alphabet1;
    private String shifted_alphabet2;
    private int mainkey1;
    private int mainkey2;

    public OOCaesarCipherTwo(int key1, int key2) {

        alphabet = "abcdefghijklmnopqrstuvwxyz";

        shifted_alphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);

        shifted_alphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);

        mainkey1=key1;

        mainkey2=key2;

    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++) {
            char currchar = encrypted.charAt(i);
            char tempCurrChar = Character.toLowerCase(currchar);
            int index;
            if (i % 2 == 0) {
                index = alphabet.indexOf(tempCurrChar);
                if (index != -1) {

                    char newChar = shifted_alphabet1.charAt(index);
                    if (Character.isLowerCase(currchar)) {
                        encrypted.setCharAt(i, newChar);
                    } else {
                        encrypted.setCharAt(i, Character.toUpperCase(newChar));
                    }
                }
            } else {
                index = alphabet.indexOf(tempCurrChar);
                if (index != -1) {

                    char newChar = shifted_alphabet2.charAt(index);
                    if (Character.isLowerCase(currchar)) {
                        encrypted.setCharAt(i, newChar);
                    } else {
                        encrypted.setCharAt(i, Character.toUpperCase(newChar));
                    }
                }

            }

        }
        return encrypted.toString();

    }
    public String decrypt(String input)
    {
        OOCaesarCipherTwo ocipher=new OOCaesarCipherTwo(26-mainkey1,26-mainkey2);

        String decrypted=ocipher.encrypt(input);

        return decrypted;

    }

}
