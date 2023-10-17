package myCat.cat.repository;

import lombok.RequiredArgsConstructor;
import myCat.cat.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

//    private final EntityManager em;
//
//    public void save(Cat cat) {
//        em.persist(cat);
//    }
//
//    public Cat findOne(Long id) {
//        return em.find(Cat.class, id);
//    }
//

//    Optional<List<Cat>> findCatsByUserId(Long userId);

    List<Cat> findCatsByUserId(Long userId);





}
