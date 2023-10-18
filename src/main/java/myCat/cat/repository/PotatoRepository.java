package myCat.cat.repository;

import myCat.cat.domain.Potato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotatoRepository extends JpaRepository<Potato, Long> {

}
