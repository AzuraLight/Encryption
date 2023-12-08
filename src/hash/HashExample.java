package hash;

import java.security.MessageDigest;

import util.HexUtil;

/**
 * 해시 함수를 사용하여 평문의 해시값을 생성하는 예제.
 * SHA-256 알고리즘을 사용하여 "Hello World" 문자열의 해시값을 계산하고,
 * 계산된 해시값을 바이트 배열과 16진수 문자열로 출력한다.
 */
public class HashExample {

    public static void main(String[] args) throws Exception {

        String algorithm = "SHA-256";
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        System.out.println("Alogorithm :" + algorithm);

        String plaintext = "Hello World";
        System.out.println("Target text : " + plaintext);
        byte[] hash = messageDigest.digest(plaintext.getBytes());

        System.out.print("Hash : ");
        for (byte b : hash)
            System.out.printf("%02X ", b);
        System.out.println("\n해쉬 길이 : " + hash.length + " byte");

        // 바이트 배열을 16진수 문자열로 변환
        String hexOutput = HexUtil.bytesToHex(hash);
        System.out.println("Hash of plaintext : " + hexOutput);

    }
}
