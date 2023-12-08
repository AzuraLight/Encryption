package jwt;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * JWT 토큰 발급 및 검증을 시연하는 애플리케이션 클래스입니다.
 * 이 클래스는 RsaKeyManager를 사용하여 RSA 키 쌍을 생성하고,
 * JwtProcessor를 사용하여 JWT 토큰을 생성 및 검증합니다.
 */
public class JwtApplication {

    public static void main(String[] args) {
        try {
            // RSA 키 쌍 생성
            KeyPair keyPair = RsaKeyManager.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // JWT 토큰 생성
            String subject = "exampleSubject";
            String jwtToken = JwtProcessor.createJwtToken(subject, privateKey);
            System.out.println("JWT Token: " + jwtToken);

            // JWT 토큰 검증
            boolean isValid = JwtProcessor.validateJwtToken(jwtToken, publicKey);
            System.out.println("Is token valid? " + isValid);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
