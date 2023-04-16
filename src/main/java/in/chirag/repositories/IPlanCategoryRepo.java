package in.chirag.repositories;

import in.chirag.entities.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
