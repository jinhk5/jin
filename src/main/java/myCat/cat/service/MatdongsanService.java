package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.CatRecordForm;
import myCat.cat.repository.MatdongsanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatdongsanService {

    private final MatdongsanRepository matdongsanRepository;

    @Transactional
    public void updateMatdongsan(CatRecordForm form, Long recordId) {



    }


}
