package ar.com.elegantsoft.breakingjpa.repo;

import ar.com.elegantsoft.breakingjpa.domain.Child;
import ar.com.elegantsoft.breakingjpa.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {
    List<Child> findAllByCname(@Param("cname") String name);
    List<Child> findAllByParent(@Param("parent") Parent parent);
    List<Child> findChildrenByCname(@Param("cname") String name);
}
