package myCat.cat.repository;

import myCat.cat.domain.MedicationManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationManageRepository extends JpaRepository<MedicationManage, Long> {

    List<MedicationManage> findMedicationManagesByCatId(Long catId);


}
