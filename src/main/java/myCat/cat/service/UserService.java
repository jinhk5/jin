package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.UserForm;
import myCat.cat.domain.User;
import myCat.cat.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
}
