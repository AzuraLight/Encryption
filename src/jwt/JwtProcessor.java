package jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * JWT 처리를 위한 유틸리티 클래스입니다.
 * 이 클래스는 주어진 RSA 개인키를 사용하여 JWT 토큰을 생성하고,
 * 공개키를 사용하여 JWT 토큰을 검증하는 기능을 제공합니다.
 */
public class JwtProcessor {

    // JWT 생성, 전자서명의 경우 개인키를 활용하여 서명
    public static String createJwtToken(String subject, PrivateKey privateKey) {

        return Jwts.builder()
                .setSubject(subject)
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    // JWT 검증, 전자서명의 경우 공개키를 활용하여 서명 검증
    public static boolean validateJwtToken(String jwtToken, PublicKey publicKey) {

        try {
            Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
