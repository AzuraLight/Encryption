package hmac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import util.HexUtil;

/**
 * HMAC을 생성하고 검증하는 예제.
 * HmacSHA256 알고리즘과 비밀키를 사용하여 "Hello World" 문자열의 HMAC을 계산하고,
 * 계산된 HMAC을 바이트 배열과 16진수 문자열로 출력한다.
 * 이후 수신자가 동일한 비밀키를 사용하여 독립적으로 HMAC을 계산하고,
 * 발신자와 수신자의 HMAC 값을 비교하여 메시지의 무결성 및 인증을 검증한다.
 */
public class HmacExample {

    public static void main(String[] args) throws Exception {

        String key = "secret";
        String plaintext = "Hello World";
        String algorithm = "HmacSHA256";

        // HMAC 인스턴스 생성
        Mac mac = Mac.getInstance(algorithm);

        // 비밀키 초기화
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        mac.init(secretKeySpec);

        // plaintext를 mac으로 변환 및 byte 배열에 저장
        byte[] hmac = mac.doFinal(plaintext.getBytes());

        // 바이트 배열을 16진수 문자열로 변환
        String hexOutput = HexUtil.bytesToHex(hmac);
        System.out.println("HMAC calculated by sender : " + hexOutput);
        System.out.println();

        // Hmac 검증
        verifyHmac(key, plaintext, hexOutput, algorithm);
    }

    private static void verifyHmac(String key, String plaintext, String hexOutput, String algorithm) throws Exception {

        // 가정: 'hexOutput'과 'receivedHmacHex'는 통신 채널을 통해 전송된다.
        // 수신자가 HMAC을 검증할 때:
        String receivedHmacHex = hexOutput; // 수신자가 받은 HMAC 값 (16진수 문자열)

        // 수신자가 동일한 키와 알고리즘으로 HMAC 인스턴스를 생성
        Mac macReceiver = Mac.getInstance(algorithm);
        SecretKeySpec secretKeySpecReceiver = new SecretKeySpec(key.getBytes(), algorithm);
        macReceiver.init(secretKeySpecReceiver);

        // 수신자가 받은 원본 메시지의 HMAC을 다시 계산
        byte[] hmacReceiver = macReceiver.doFinal(plaintext.getBytes());

        // 수신자가 계산한 HMAC을 16진수 문자열로 변환
        String hexOutputReceiver = HexUtil.bytesToHex(hmacReceiver);
        System.out.println("HMAC calculated by receiver : " + hexOutputReceiver);

        // 발신자의 HMAC과 수신자가 계산한 HMAC을 비교
        boolean isHmacMatch = receivedHmacHex.equals(hexOutputReceiver);
        if (isHmacMatch) {
            System.out.println("HMAC verification successful: The data is intact and authentic.");
        } else {
            System.out.println("HMAC verification failed: The data is corrupted or the key is incorrect.");
        }
    }

}
