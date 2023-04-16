package in.chirag.services;


import in.chirag.entities.Plan;

import java.util.List;
import java.util.Map;

public interface IPlanService {

    Map<Integer, String> getPlanCategories();

    boolean createPlan(Plan plan);

    List<Plan> getAllPlan();

    Plan getPlanById(Integer planId);

    boolean delete(Integer planId);

    boolean updatePlan(Plan plan);

    boolean enableDisablePlan(Integer planId, Boolean IsEnableDisable);
}
