package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.MedicineForm;
import myCat.cat.domain.Cat;
import myCat.cat.domain.MedicationManage;
import myCat.cat.repository.MedicationManageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MedicationManageService {

    private final MedicationManageRepository medicationManageRepository;

    @Transactional
    public long registerMedication(MedicineForm form, Cat cat) {
        MedicationManage medicine = new MedicationManage(cat, form.getMedicineName());
        medicationManageRepository.save(medicine);
        return medicine.getId();
    }

    @Transactional
    public void updateMedicationInfo(MedicineForm form, Long medicineId) {
        MedicationManage medicine = medicationManageRepository.getReferenceById(medicineId);
        medicine.update(form.getMedicineName());
    }

    public List<MedicationManage> getMedicineList(Long catId) {
        return medicationManageRepository.findMedicationManagesByCatId(catId);
    }

    public MedicationManage getMedicineInfo(Long medicineId) {
        return medicationManageRepository.getReferenceById(medicineId);
    }

}
