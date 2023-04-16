package in.chirag.repositories;

import in.chirag.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepo extends JpaRepository<Plan, Integer> {

}
