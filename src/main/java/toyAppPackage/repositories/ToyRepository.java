package toyAppPackage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyAppPackage.data.Toy;

@Repository //gewone beste practice dit plaatsen voor andere mensen
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}

//JpaRepository is advanced repository dan CrudRepository
//In <> moeten wrapper class gebruiken dus Integer ipv primitieve int