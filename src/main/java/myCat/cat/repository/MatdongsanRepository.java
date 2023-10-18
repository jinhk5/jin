package myCat.cat.repository;

import myCat.cat.domain.Matdongsan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatdongsanRepository extends JpaRepository<Matdongsan, Long> {




}
