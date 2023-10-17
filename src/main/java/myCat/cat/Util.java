package myCat.cat;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public static PrincipalDetails getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            Object userInfo = authentication.getPrincipal();
            if(userInfo instanceof PrincipalDetails) {
                return (PrincipalDetails) userInfo;
            }
        }
        return null;
    }
}
