package myCat.cat.service;

import myCat.cat.domain.Cat;
import myCat.cat.domain.MedicationManage;
import myCat.cat.domain.User;
import myCat.cat.repository.CatRepository;
import myCat.cat.repository.MedicationManageRepository;
import org.junit.jupiter.api.DisplayName;
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
class MedicationManageServiceTest {

    @Autowired
    MedicationManageRepository medicationManageRepository;
    @Autowired
    MedicationManageService medicationManageService;
    @Autowired
    UserService userService;
    @Autowired
    CatRepository catRepository;

    MedicationManage medicine = null;

    @Test
    @Rollback(value = false)
    @DisplayName("약 종류 등록 테스트")
    public void createMedication() throws Exception {
        //given
        User user = userService.getLoginUserById(1L);
        Cat cat = new Cat(user, "catTest", "catTest", "catType", 0, "2020-11-11");
        catRepository.save(cat);
        medicine = new MedicationManage(cat, "medicineName");

        //when
        MedicationManage savedMedicine = medicationManageRepository.save(medicine);

        //then
        assertEquals(medicine, medicationManageService.getMedicineInfo(savedMedicine.getId()));
    }

}