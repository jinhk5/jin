package myCat.cat.service;

import myCat.cat.controller.CatForm;
import myCat.cat.domain.Cat;
import myCat.cat.domain.User;
import myCat.cat.repository.CatRepository;
import myCat.cat.repository.UserRepository2;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    Cat cat = null;

//    @BeforeAll
    public void createUserAndCat() {
        User user = new User("user1", "user1", "user1@test.com", "user1");
        userRepository2.save(user);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("고양이 등록 테스트")
    public void registerCat() throws Exception {
        //given
        User user = userRepository2.getReferenceById(1L);
        cat = new Cat(user, "cat1", "profileCat", "kc", 0, "2020-10-10");

        //when
        Cat savedCat = catRepository.save(cat);

        //then
        assertEquals(cat, catService.findCat(savedCat.getId()));
    }

    @Test
    @DisplayName("고양이 수정 테스트")
    @Rollback(value = false)
    public void updateCat() throws Exception {
        //given
        cat = catRepository.getReferenceById(3L);

        //when
        CatForm form = new CatForm();
        form.setName("cat2");

        catService.updateCat(form, cat.getId());

        //then
        assertEquals(catService.findCat(cat.getId()).getName(), "cat2");
    }

    @Test
    @DisplayName("고양이 정보 불러오기 테스트")
    @Rollback(value = false)
    public void getCatInfoTest() throws Exception {
        //given
        User user = userRepository2.getReferenceById(1L);
        cat = new Cat(user, "cat3", "cat3", "cat3", 0, "2020-10-11");
        catRepository.save(cat);

        //when
        Cat findCat = catService.findCat(cat.getId());
        System.out.println(findCat.toString());

        //then
        assertEquals(findCat.getName(), cat.getName());
        assertEquals(findCat.getGender(), cat.getGender());
        assertEquals(findCat.getBirthdate(), cat.getBirthdate());
        assertEquals(findCat.getType(), cat.getType());
        assertEquals(findCat.getProfile(), cat.getProfile());
    }

    @Test
    @DisplayName("고양이 리스트 불러오기")
    public void getCatList() throws Exception {
        //given


        //when
        List<Cat> catList = catRepository.findCatsByUserId(1L);
        System.out.println("size : " + catList.size());

        //then
        assertEquals(catList.size(), 5);
    }


}