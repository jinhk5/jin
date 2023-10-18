package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.CatRecordForm;
import myCat.cat.domain.Medication;
import myCat.cat.repository.MedicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Transactional
    public void updateMedication(CatRecordForm form, Long recordId) {
        Medication medication = medicationRepository.findMedicationByCatRecordId(recordId);
        medication.update(form.getMedicationManage());
    }

    public Medication findMedication(Long recordId) {
        return medicationRepository.findMedicationByCatRecordId(recordId);
    }

}
