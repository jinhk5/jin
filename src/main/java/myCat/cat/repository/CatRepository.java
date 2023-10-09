package myCat.cat.repository;

import lombok.RequiredArgsConstructor;
import myCat.cat.domain.Cat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CatRepository {

    private final EntityManager em;

    public void save(Cat cat) {
        em.persist(cat);
    }

    public Cat findOne(Long id) {
        return em.find(Cat.class, id);
    }

    public List<Cat> findAllByUser(Long id) {
        return em.createQuery("select c from Cat c where c.user = :user", Cat.class)
                .setParameter("user", id)
                .getResultList();
    }
}
