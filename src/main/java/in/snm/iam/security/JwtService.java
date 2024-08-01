package in.snm.iam.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// @Service
// @RequiredArgsConstructor
public class JwtService {

    // @Value("${application.security.jwt.secret-key}")
    // private String secretKey;
    // @Value("${application.security.jwt.access-expiration}")
    // private long jwtAccessExpiration;
    // @Value("${application.security.jwt.refresh-expiration}")
    // private long jwtRefreshExpiration;

    // public String extractUserEmail(String token) {
    //     return extractClaim(token, Claims::getSubject);
    // }

    // public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    //     final Claims claims = extractAllClaims(token);
    //     return claimsResolver.apply(claims);
    // }

    // public String generateToken(UserDetails userDetails) {
    //     return generateToken(new HashMap<>(), userDetails);
    // }

    // public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    //     return buildToken(new HashMap<>(), userDetails, jwtAccessExpiration);
    // }

    // public String generateRefreshToken(
    //         UserDetails userDetails
    // ) {
    //     return buildToken(new HashMap<>(), userDetails, jwtRefreshExpiration);
    // }

    // private String buildToken(HashMap<String, Object> extraClaims, UserDetails userDetails, long jwtExpiration) {

    //     var authorities = userDetails.getAuthorities()
    //             .stream()
    //             .map(GrantedAuthority::getAuthority)
    //             .toList();

    //     return Jwts
    //             .builder()
    //             .setClaims(extraClaims)
    //             .setSubject(userDetails.getUsername())
    //             .setIssuedAt(new Date(System.currentTimeMillis()))
    //             .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
    //             .claim("authorities", authorities)
    //             //.signWith(getSignInKey(), SignatureAlgorithm.HS512)
    //             .signWith(getSignInKey())
    //             .compact();
    // }

    // public boolean isTokenValid(String token, UserDetails userDetails) {
    //     final String username = extractUserEmail(token);
    //     return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    // }

    // private boolean isTokenExpired(String token) {
    //     return extractExpiration(token).before(new Date());
    // }

    // private Date extractExpiration(String token) {
    //     return extractClaim(token, Claims::getExpiration);
    // }

    // private Claims extractAllClaims(String token) {
    //     return Jwts
    //             .parserBuilder()
    //             .setSigningKey(getSignInKey())
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody();
    // }

    // private Key getSignInKey() {
    //     byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    //     return Keys.hmacShaKeyFor(keyBytes);
    // }


}
