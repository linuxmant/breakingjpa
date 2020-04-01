package ar.com.elegantsoft.breakingjpa.repo;

import ar.com.elegantsoft.breakingjpa.domain.GreatChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreatChildRepo extends JpaRepository<GreatChild, Long> {
}
