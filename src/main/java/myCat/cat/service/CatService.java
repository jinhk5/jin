package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.PrincipalDetails;
import myCat.cat.PrincipalDetailsService;
import myCat.cat.Util;
import myCat.cat.controller.CatForm;
import myCat.cat.domain.Cat;
import myCat.cat.domain.User;
import myCat.cat.repository.CatRepository;
import myCat.cat.repository.UserRepository;
import myCat.cat.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;
    private final UserRepository2 userRepository2;
    @Transactional
    public Long registerCat(User user, Cat catInfo) {
        Cat cat = new Cat(
                userRepository2.findUserByLoginId(Objects.requireNonNull(Util.getUserInfo()).getUsername()),
                catInfo.getName(),
                catInfo.getProfile(),
                catInfo.getType(),
                catInfo.getGender(),
                catInfo.getBirthdate());
        catRepository.save(cat);
        return cat.getId();
    }

    @Transactional
    public void updateCat(CatForm form, Long catId) {

        Cat cat = catRepository.getReferenceById(catId);

        cat.update(
                form.getName(),
                form.getProfile(),
                form.getType(),
                form.getGender(),
                form.getBirthDate()
        );
    }

    public Cat findCat(Long catId) {
        return catRepository.getReferenceById(catId);
    }

    public Optional<List<Cat>> findMyCats(Long userId) {
        return catRepository.findCatsByUserId(userId);
    }
}
