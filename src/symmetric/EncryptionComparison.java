package symmetric;

import javax.crypto.SecretKey;

import util.CryptoUtils;

/**
 * AES와 RC4 암호화 알고리즘을 비교하는 클래스.
 * 이 클래스는 AES와 RC4 알고리즘을 사용하여 문자열을 암호화하고 복호화한 후, 결과를 출력합니다.
 * 클래스 내에서 키 생성, 암호화, 복호화 과정을 구현하여 두 암호화 방식의 차이점을 명확히 비교합니다.
 * 이를 통해 블록 암호화와 스트림 암호화 방식의 사용 예와 차이점을 이해할 수 있습니다.
 */
public class EncryptionComparison {

    public static void main(String[] args) throws Exception {
        String text = "Hello World!";

        // AES 암호화 및 복호화
        System.out.println("AES Encryption:");
        SecretKey aesKey = CryptoUtils.generateKey("AES", 128);

        String aesEncrypted = CryptoUtils.encrypt(text, aesKey, "AES");
        System.out.println("Encrypted: " + aesEncrypted);

        String aesDecrypted = CryptoUtils.decrypt(aesEncrypted, aesKey, "AES");
        System.out.println("Decrypted: " + aesDecrypted);

        // RC4 암호화 및 복호화
        System.out.println("\nRC4 Encryption:");
        SecretKey rc4Key = CryptoUtils.generateKey("RC4", 128);

        String rc4Encrypted = CryptoUtils.encrypt(text, rc4Key, "RC4");
        System.out.println("Encrypted: " + rc4Encrypted);

        String rc4Decrypted = CryptoUtils.decrypt(rc4Encrypted, rc4Key, "RC4");
        System.out.println("Decrypted: " + rc4Decrypted);
    }
}
