package asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import util.HexUtil;

/**
 * RSA를 사용한 비대칭 키 암호화 및 복호화 예제.
 * 공개키로 평문을 암호화하고 개인키로 암호화된 데이터를 복호화한다.
 * RSA 알고리즘과 2048비트 키 길이를 사용한다.
 */
public class AsymmetricExample {

    public static void main(String[] args) throws Exception {

        String algorithm = "RSA";
        String plaintext = "Hello World";

        // 키 쌍 생성
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(2048); // 키 길이 지정
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 공개키로 암호화
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey); // 암호화 모드 설정 및 공개키로 Cipher 초기화
        byte[] encrypted = cipher.doFinal(plaintext.getBytes()); // 평문 암호화 및 byte배열로 저장

        // 바이트 배열을 16진수 문자열로 변환
        String encryptedString = HexUtil.bytesToHex(encrypted);
        System.out.println("Encrypted text : " + encryptedString);

        // 개인키로 복호화
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(encrypted);

        // 복호화된 데이터를 문자열로 변환하여 출력
        String decryptedString = new String(decrypted);
        System.out.println("Decrypted text : " + decryptedString);

        // 암호화 및 복호화 검증
        if (plaintext.equals(decryptedString)) {
            System.out.println("Asymmetric encryption and decryption successful.");
        } else {
            System.out.println("Asymmetric encryption and decryption failed.");
        }
    }

}
