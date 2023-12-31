package myCat.cat.repository;

import myCat.cat.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    Medication findMedicationByCatRecordId(Long recordId);

}
