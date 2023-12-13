package symmetric;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoUtils;

/**
 * AES 암호화를 사용한 예제 클래스.
 * 이 클래스는 SecureRandom을 사용하여 생성된 128비트 AES 키를 사용하여 평문 문자열을 암호화하고
 * 복호화합니다.
 * AES 암호화의 기본적인 사용법을 보여주며, 암호화된 데이터의 안전한 처리 방법을 이해할 수 있도록 합니다.
 */
public class EncryptionWithSecretKeySpec {

    public static void main(String[] args) throws Exception {

        byte[] keyBytes = new byte[16]; // AES 128비트를 생성하기 위한 바이트 길이 (16 * 8)
        new SecureRandom().nextBytes(keyBytes); // SecureRandom을 사용해서 안전한 난수를 생성하고 keyBytes 배열에 채움
        SecretKeySpec aesKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        // 실제 암호화할 평문
        String plaintext = "Hello World";
        System.out.println("Plaintext: " + plaintext);

        String aesEncrypted = CryptoUtils.encrypt(plaintext, aesKey, "AES");
        System.out.println("Encrypted: " + aesEncrypted);

        String aesDecrypted = CryptoUtils.decrypt(aesEncrypted, aesKey, "AES");
        System.out.println("Decrypted: " + aesDecrypted);
    }
}
