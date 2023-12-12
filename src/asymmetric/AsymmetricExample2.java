package asymmetric;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import util.CryptoUtils;
import util.HexUtil;

/**
 * RSA를 사용한 비대칭 키 암호화 및 복호화 예제.
 * 이 클래스는 공개키로 평문을 암호화하고, 개인키로 암호화된 데이터를 복호화하는 과정을 시연합니다.
 * RSA 알고리즘과 2048비트 키 길이를 사용하여 안전한 암호화 및 복호화를 수행합니다.
 * 이 예제는 비대칭 암호화의 기본 원리와 구현 방법을 보여줍니다.
 * 또한 이 클래스는 CryptoUtils를 활용하여 코드의 재활용성과 가독성을 높였습니다.
 */
public class AsymmetricExample2 {

    public static void main(String[] args) throws Exception {

        String plaintext = "Hello World";

        // RSA 키 쌍 생성
        KeyPair keyPair = CryptoUtils.generateRSAKeyPair(2048);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 공개키로 암호화
        byte[] encrypted = CryptoUtils.encryptRSA(plaintext.getBytes(), publicKey);
        String encryptedString = HexUtil.bytesToHex(encrypted);
        System.out.println("Encrypted text : " + encryptedString);

        // 개인키로 복호화
        byte[] decrypted = CryptoUtils.decryptRSA(encrypted, privateKey);
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
