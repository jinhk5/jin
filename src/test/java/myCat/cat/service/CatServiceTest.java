package myCat.cat.service;

import myCat.cat.domain.Cat;
import myCat.cat.domain.User;
import myCat.cat.repository.CatRepository;
import myCat.cat.repository.UserRepository2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CatServiceTest {

    @Autowired
    CatRepository catRepository;
    @Autowired
    CatService catService;
    @Autowired
    UserRepository2 userRepository2;

    @Test
    @Rollback(value = false)
    public void registerCat() throws Exception {
        //given
        User user = new User("user1", "user1", "user1@test.com", "user1");
        userRepository2.save(user);
        Cat cat = new Cat(user, "cat1", "profileCat", "kc", 0, "2020-10-10");

        //when
        Cat savedCat = catRepository.save(cat);

        //then
        assertEquals(cat, catService.findCat(savedCat.getId()));
    }


}