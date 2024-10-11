package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@PropertySource({"classpath:/application.properties"})
@Component
public class JwtProcessor { // 헬퍼클래스란?
//    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 10; // 1

    @Value("${jwt.token-validity}")
    private int TOKEN_VALID_MILISECOND;
//    private String secretKey = "zzzzzzzzzzzzzzzzz충분히 긴 임의의(랜덤한) 비밀키 문자열 배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf배정asdfasdasdasdf ";

    @Value("${jwt.secret-key}")
    private String secretKey;

    private Key key;
//    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
// private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); -- 운영시 사용

    @Value("${jdbc.testNumber}")
    int testNumber;

    @PostConstruct
    public void init() {
        // secretKey가 주입된 이후에 key 값을 초기화
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        System.out.println("TOKEN_VALID_MILISECOND" + TOKEN_VALID_MILISECOND);
        System.out.println("secretKey" + secretKey);
    }

    // JWT 생성
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND))
                .signWith(key)
                .compact();
    }

    // JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생
    // 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException,
    // IllegalArgumentException
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }
}
