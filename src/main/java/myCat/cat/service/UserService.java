package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.LoginForm;
import myCat.cat.controller.UserForm;
import myCat.cat.domain.User;
import myCat.cat.repository.UserRepository;
import myCat.cat.repository.UserRepository2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRepository2 userRepository2;
    private final BCryptPasswordEncoder encoder;


    @Transactional
    public Long registerUser(UserForm userInfo) {
        User user = new User(
            userInfo.getLoginId(),
                userInfo.getName(),
                userInfo.getEmail(),
                userInfo.getNickname()
        );
        userRepository.save(user);
        return user.getId();

    }

    @Transactional
    public void updateUser(Long id, UserForm userInfo) {
        User user = userRepository.findOne(id);
        user.update(userInfo.getNickname(), userInfo.getEmail());
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    // loginId 중복 체크
    public boolean checkLoginIdDuplicate(String loginId) {
        return userRepository2.existsByLoginId(loginId);
    }

    // nickname 중복 체크
    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository2.existsByNickname(nickname);
    }

    // 회원가입
    public void join(UserForm req) {
        userRepository2.save(req.toEntity(encoder.encode(req.getPassword())));
    }

    // 로그인
    public User login(LoginForm req) {
        Optional<User> optionalUser = userRepository2.findByLoginId(req.getLoginId());

        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    public User getLoginUserById(Long userId) {
        if(userId == null) return null;

        Optional<User> optionalUser = userRepository2.findById(userId);
        return optionalUser.orElse(null);

    }

    public User getLoginUserByLoginId(String loginId) {
        if(loginId == null) return null;

        Optional<User> optionalUser = userRepository2.findByLoginId(loginId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }


}
