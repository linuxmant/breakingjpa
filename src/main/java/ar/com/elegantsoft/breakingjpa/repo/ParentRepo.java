package ar.com.elegantsoft.breakingjpa.repo;

import ar.com.elegantsoft.breakingjpa.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Long> {
}
