package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.CatRecordForm;
import myCat.cat.domain.*;
import myCat.cat.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.ServiceNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CatRecordService {

    private final CatRecordRepository catRecordRepository;
    private final CatRepository catRepository;
    private final MatdongsanRepository matdongsanRepository;
    private final PotatoRepository potatoRepository;
    private final MedicationRepository medicationRepository;

    @Transactional
    public Long registerCatRecord(Long catId, CatRecordForm form) throws ServiceNotFoundException {
        CatRecord catRecord = new CatRecord(
                catRepository.getReferenceById(catId),
                form.getDate(),
                form.getRecordType()
        );
        catRecordRepository.save(catRecord);
        registerEachRecord(catRecord, form);

        return catRecord.getId();

    }

    public void registerEachRecord(CatRecord catRecord, CatRecordForm form) throws ServiceNotFoundException {
        RecordType type = form.getRecordType();
        if(type.equals(RecordType.MDS)) {
            Matdongsan matdongsan = new Matdongsan(catRecord, form.getDate(), form.getTime(), form.getMdsStatus(), form.getCntPerTime());
            matdongsanRepository.save(matdongsan);
        }else if(type.equals(RecordType.POTATO)) {
            Potato potato = new Potato(catRecord, form.getDate(), form.getTime(), form.getPotatoStatus());
            potatoRepository.save(potato);
        }else if(type.equals(RecordType.MEDICINE)) {
            Medication medication = new Medication(catRecord, form.getMedicationManage());
            medicationRepository.save(medication);
        }else {
            throw new ServiceNotFoundException("타입을 선택해주세요.");
        }

    }

    public List<CatRecord> myCatRecordsByDate(String date, Long catId) {
        return catRecordRepository.findCatRecordsByDateAndCat(date, catId);
    }


}
