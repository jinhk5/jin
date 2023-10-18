package myCat.cat.service;

import lombok.RequiredArgsConstructor;
import myCat.cat.controller.CatRecordForm;
import myCat.cat.domain.Potato;
import myCat.cat.repository.PotatoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PotatoService {

    private final PotatoRepository potatoRepository;

    @Transactional
    public void updatePotato(CatRecordForm form, Long recordId) {
        Potato potato = potatoRepository.findPotatoByCatRecordId(recordId);
        potato.update(form.getTime(), form.getPotatoStatus());
    }

    public Potato findPotato(Long recordId) {
        return potatoRepository.findPotatoByCatRecordId(recordId);
    }

}
