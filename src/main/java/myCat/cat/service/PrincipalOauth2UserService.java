package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myCat.cat.PrincipalDetails;
import myCat.cat.controller.KakaoUserInfo;
import myCat.cat.controller.NaverUserInfo;
import myCat.cat.domain.User;
import myCat.cat.domain.UserRole;
import myCat.cat.repository.OAuth2UserInfo;
import myCat.cat.repository.UserRepository2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository2 userRepository2;
    private final BCryptPasswordEncoder encoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("getAttributes : {}", oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;

        String provider = userRequest.getClientRegistration().getRegistrationId();

        if(provider.equals("kakao")) {
            log.info("request kakao login");
            oAuth2UserInfo = new KakaoUserInfo((Map)oAuth2User.getAttributes() );
        }else if(provider.equals("naver")) {
            log.info("request naver login");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }

        log.info("oauth : " + oAuth2UserInfo);

        String providerId = oAuth2UserInfo.getProviderId();
        String email = oAuth2UserInfo.getEmail();
        String loginId = provider + "_" + providerId;
        String nickname = oAuth2UserInfo.getName();

        log.error("nickname : " + nickname);

        Optional<User> optionalUser = userRepository2.findByLoginId(loginId);
        User user = null;

        if(optionalUser.isEmpty()) {
            user = User.builder()
                    .loginId(loginId)
                    .nickname(nickname)
                    .provider(provider)
                    .providerId(providerId)
                    .role(UserRole.USER)
                    .email(email)
                    .registerDate(LocalDateTime.now())
                    .build();
            userRepository2.save(user);

        }else {
            user = optionalUser.get();
            log.info("here : " + user.getNickname());
        }
        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }
}
