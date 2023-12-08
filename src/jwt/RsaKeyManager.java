package jwt;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA 키 관리를 위한 유틸리티 클래스입니다.
 * 이 클래스는 RSA 키 쌍을 생성하고, PEM 포맷으로 키를 변환하는 기능을 제공합니다.
 * 또한, PEM 포맷 문자열에서 RSA 키를 복원하는 기능도 포함합니다.
 */
public class RsaKeyManager {

    // RSA 키 쌍 생성
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 공개키와 개인키를 PEM 포맷으로 변환
        String publicKeyPem = publicKeyToPem(keyPair.getPublic());
        String privateKeyPem = privateKeyToPem(keyPair.getPrivate());

        // 콘솔에 출력
        StringBuilder sb = new StringBuilder();
        sb.append("Public Key : \n").append(publicKeyPem).append("\n\n");
        sb.append("Private Key : \n").append(privateKeyPem);

        System.out.println(sb.toString());

        return keyPair;
    }

    // 개인키를 PEM 포맷으로 변환
    public static String privateKeyToPem(PrivateKey privateKey) {

        String encodedKey = Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(privateKey.getEncoded());

        return "-----BEGIN PRIVATE KEY-----\n" + encodedKey + "\n-----END PRIVATE KEY-----";
    }

    // 공개키를 PEM 포맷으로 변환
    public static String publicKeyToPem(PublicKey publicKey) {

        String encodedKey = Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(publicKey.getEncoded());

        return "-----BEGIN PUBLIC KEY-----\n" + encodedKey + "\n-----END PUBLIC KEY-----";
    }

    // PEM 포맷의 문자열에서 개인키 복원, PKCS#8은 개인키 정보를 저장하는 표준 포맷
    public static PrivateKey getPrivateKeyFromPem(String pemString) throws Exception {

        String privateKeyPEM = pemString.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePrivate(keySpec);
    }

    // PEM 포맷의 문자열에서 공개키 복원, X.509는 공개키 인증서의 표준 포맷
    public static PublicKey getPublicKeyFromPem(String pemString) throws Exception {

        String publicKeyPEM = pemString.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePublic(keySpec);
    }
}