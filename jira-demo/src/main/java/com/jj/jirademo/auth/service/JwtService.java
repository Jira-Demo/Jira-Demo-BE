package com.jj.jirademo.auth.service;

import com.jj.jirademo.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="203858b7037a92cde4a6915ca8830871907e11ca40d04df36b61c5315817bfbf";
    public String findUsername(String token) {
        return exportToken(token, Claims::getSubject);
    }

    private <T> T exportToken(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    private Key getSigningKey() {
        byte[] signingKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(signingKey);

    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = findUsername(token);
        return (username.equals(userDetails.getUsername()) && !exportToken(token,Claims::getExpiration).before(new Date()));
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
