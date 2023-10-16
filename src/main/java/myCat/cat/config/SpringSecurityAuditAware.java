package myCat.cat.config;

import myCat.cat.PrincipalDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Optional;

@Configuration
public class SpringSecurityAuditAware implements AuditorAware<Long> {


    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            Object userInfo = authentication.getPrincipal();
            if(userInfo instanceof PrincipalDetails) {
                return ((PrincipalDetails) userInfo).getId().describeConstable();
            }
        }
        return Optional.empty();
    }
}
