package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.domain.Cat;
import myCat.cat.domain.User;
import myCat.cat.repository.CatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    @Transactional
    public Long registerCat(User user, Cat catInfo) {
        Cat cat = new Cat(
                user,
                catInfo.getName(),
                catInfo.getProfile(),
                catInfo.getType(),
                catInfo.getGender(),
                catInfo.getBirthdate());
        catRepository.save(cat);
        return cat.getId();
    }

    @Transactional
    public void update(Cat catInfo) {
        Cat cat = catRepository.findOne(catInfo.getId());
        cat.update(
                catInfo.getName(),
                catInfo.getProfile(),
                catInfo.getType(),
                catInfo.getGender(),
                catInfo.getBirthdate()
        );
    }

    public Cat findCat(Long catId) {
        return catRepository.findOne(catId);
    }

    public List<Cat> findMyCats(Long memberId) {
        return catRepository.findAllByUser(memberId);
    }
}
