# 해시 함수와 HMAC 예제

해시 함수와 HMAC은 데이터의 무결성과 인증을 보장하기 위해 사용됩니다. 이 예제는 Java로 구현된 해시 함수와 HMAC의 사용 방법을 보여줍니다.

## 해시 함수 예제 : HashExample.java

이 예제는 SHA-256 해시 알고리즘을 사용하여 주어진 평문의 해시값을 생성합니다.
해시값은 바이트 배열로 생성되며, 이를 16진수 문자열로 변환하여 출력합니다.

## HMAC 예제 : HmacExmaple.java
이 예제는 HmacSHA256 알고리즘과 비밀키를 사용하여 주어진 평문의 HMAC을 생성합니다.
HMAC 검증 절차를 통해 데이터의 무결성과 인증을 확인할 수 있습니다.

## HexUtil 클래스 : HexUtil.java
바이트 배열을 16진수 문자열로 변환하는데 사용되는 유틸리티 클래스입니다.
이 유틸리티는 해시와 HMAC 예제에서 출력 포맷팅을 위해 사용됩니다.

## RSA 예제 : AsymmetricExample.java
RSA 암호화 알고리즘을 사용하여 주어진 평문을 암호화하고, 그 암호화된 텍스트를 다시 복호화하는 방법을 보여줍니다.


# JWT 처리 예제

JWT 처리 예제는 jjwt 라이브러리를 사용하여 RSA 키 쌍을 기반으로 JWT를 생성하고 검증합니다. 이 예제들은 Java로 구현되었으며, 보안 통신에 JWT를 효율적으로 사용하기 위한 방법을 보여줍니다.

## RsaKeyManager 클래스 : RsaKeyManager.java

이 클래스는 RSA 키 쌍을 생성하고, PEM 포맷으로 키를 변환하는 기능을 제공합니다. PEM 포맷은 키를 안전하게 저장하고 교환하기 위한 표준 방식입니다. 이 클래스는 jjwt 라이브러리와 함께 사용되어 JWT 처리에 필요한 RSA 키 쌍을 제공합니다.

## JwtProcessor 클래스 : JwtProcessor.java

JwtProcessor 클래스는 jjwt 라이브러리를 활용하여 JWT 토큰을 생성하고 검증합니다. 개인키를 사용하여 JWT에 서명하고, 해당 공개키로 서명을 검증하는 기능을 담당합니다. 이 클래스는 보안 통신을 위한 JWT 생성 및 검증 프로세스를 캡슐화합니다.

## JwtApplication 클래스 : JwtApplication.java

JwtApplication 클래스는 RsaKeyManager와 JwtProcessor를 사용하여 실제로 JWT 토큰을 생성하고 검증하는 애플리케이션을 구현합니다. 이 클래스는 JWT의 전체적인 생성 및 검증 프로세스를 시연하며, 서버 간 통신이나 사용자 인증에 사용될 수 있습니다.

## 사용된 라이브러리

- jjwt : JWT를 생성하고 검증하는 데 사용된 Java 라이브러리입니다. jjwt는 JWT의 생성, 파싱 및 검증을 간편하게 만들어주는 다양한 기능을 제공합니다.
