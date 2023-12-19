import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Caesercipher_1a {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plainText, int caesarKey) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);

            if (Character.isLetter(currentChar)) {
                String alphabet = Character.isUpperCase(currentChar) ? ALPHABET.toUpperCase() : ALPHABET;
                int plainNumeric = alphabet.indexOf(currentChar);
                int cipherNumeric = (plainNumeric + caesarKey) % 26;

                if (cipherNumeric < 0) {
                    cipherNumeric = alphabet.length() + cipherNumeric;
                }

                char cipherChar = alphabet.charAt(cipherNumeric);
                cipherText.append(cipherChar);
            } else {
                // If the character is not a letter, leave it unchanged
                cipherText.append(currentChar);
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String ctext, int cserkey) {
        String ptext = "";

        for (int i = 0; i < ctext.length(); i++) {
            char currentChar = ctext.charAt(i);

            if (Character.isLetter(currentChar)) {
                String alphabet = Character.isUpperCase(currentChar) ? ALPHABET.toUpperCase() : ALPHABET;
                int ciphernumeric = alphabet.indexOf(currentChar);
                int plainnumeric = (ciphernumeric - cserkey) % 26;

                if (plainnumeric < 0) {
                    plainnumeric = alphabet.length() + plainnumeric;
                }

                char plainchar = alphabet.charAt(plainnumeric);
                ptext += plainchar;
            } else {
                // If the character is not a letter, leave it unchanged
                ptext += currentChar;
            }
        }

        return ptext;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the PLAIN TEXT for Encryption: ");
        String plaintext = br.readLine();
        String ciphertext = "";
        String key;
        int cserkey;

        System.out.println("Enter the CAESAR KEY between 0 and 25:");
        key = br.readLine();
        cserkey = Integer.parseInt(key);

        System.out.println("ENCRYPTION");
        ciphertext = encrypt(plaintext, cserkey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        plaintext = decrypt(ciphertext, cserkey);
        System.out.println("PLAIN TEXT: " + plaintext);
    }
}
