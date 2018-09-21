package com.pinnuli.utils;

import com.pinnuli.model.PayloadInfo;
import com.pinnuli.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-05
 */

public class JwtUtil {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String SECRET_KEY= "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545df>?N<:{";

    public static String createJWT(String id, String subject, long ttlMillis, PayloadInfo payloadInfo) throws Exception {
        // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成JWT创建的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建一个base64需要的key
        SecretKey key = generalKey();

        //将payloadInfo转换为Claims类型
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userId", payloadInfo.getUserId());
        claims.put("userName", payloadInfo.getUserName());
        // 下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);

        // 设置过期时间
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt：要解密的token
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        // 签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        // 得到DefaultJwtParser,设置签名的秘钥,设置需要解析的jwt
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        log.debug("jwtutil:{}",claims.get("userId"));
        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(SECRET_KEY);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}
