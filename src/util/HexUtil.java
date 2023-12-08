package util;

/**
 * 바이트 배열을 16진수 문자열로 변환하는 유틸리티 클래스.
 * 바이트 배열을 받아 16진수 문자열로 변환하여 반환한다.
 */
public class HexUtil {

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
