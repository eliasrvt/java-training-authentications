package com.example.trainingjavajwt.security;

import com.example.trainingjavajwt.constants.Constants;
import com.example.trainingjavajwt.models.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    public JwtUser validate(String token){
        JwtUser jwtUser = null;

        try{
            Claims payload = Jwts.parser()
                    .setSigningKey(Constants.JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser(
                    payload.getSubject(),
                    (String) payload.get(Constants.USER_ID),
                    (String) payload.get(Constants.ROLE));

        }catch (Exception e){
            System.out.println(e);
        }

        return jwtUser;
    }
}
