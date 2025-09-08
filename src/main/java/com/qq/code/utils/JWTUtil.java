package com.qq.code.utils;


import com.qq.code.config.properties.JWTProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

//    @Autowired
//    private JWTProperties jwtProperties;
//
//    @Autowired
//    private SecretKey secretKey;

    private final JWTProperties jwtProperties;
    private final SecretKey secretKey;

    public JWTUtil(JWTProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.secretKey = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }

    /**
     * 生成JWT token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())                  //设置用户名
                .setIssuedAt(new Date(System.currentTimeMillis()))      //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))    //设置过期时间
                .signWith(secretKey, SignatureAlgorithm.ES256)
                .compact();

    }

    /**
     * 通过账号生成JWT token
      * @param account
     * @return
     */
    public String generateToken(String account){
        Map<String,Object> chaims = new HashMap<>();
        chaims.put("account",account);

       return Jwts.builder()
               .setClaims(chaims)
               .setSubject(account)
               .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
               .signWith(secretKey,SignatureAlgorithm.HS256)
               .compact();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    private Claims extractClaims(String token){
       return Jwts.parserBuilder()
               .setSigningKey(secretKey)
               .build()
               .parseClaimsJws(token)
               .getBody();
    }

    /**
     * 从token提取用户名
     * @param token
     * @return
     */
    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    /**
     * 从token中提取过期时间
     * @param token
     * @return
     */
    public Date extractExpiration(String token){
        return extractClaims(token).getExpiration();
    }

    /**
     * 建议token是否有效
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    public boolean isTokenExpired(String token){
       return extractExpiration(token).before(new Date());
    }

    /**
     * 去掉Bearer前缀，获取纯token
     * @param bearerToken
     * @return
     */
    public String resolveToken(String bearerToken){
        if(bearerToken != null && !bearerToken.startsWith(jwtProperties.getPrefix())){
            return bearerToken.substring(jwtProperties.getPrefix().length()).trim();
        }
        return null;
    }


}
