package myCat.cat.repository;

import myCat.cat.domain.CatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRecordRepository extends JpaRepository<CatRecord, Long> {

    List<CatRecord> findCatRecordsByDateAndCat(String date, Long catId);


}
