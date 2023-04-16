package in.chirag.services;

import in.chirag.entities.Plan;
import in.chirag.entities.PlanCategory;
import in.chirag.repositories.IPlanCategoryRepo;
import in.chirag.repositories.IPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanService implements IPlanService {

    @Autowired
    private IPlanCategoryRepo planCategoryRepo;

    @Autowired
    private IPlanRepo planRepo;


    @Override
    public Map<Integer, String> getPlanCategories() {
        List<PlanCategory> planCategoriesList = planCategoryRepo.findAll();
        Map<Integer, String> planCategories = new HashMap<>();

        planCategoriesList.forEach(planCategory -> {
            planCategories.put(planCategory.getPlanCategoryID(), planCategory.getPlanCategoryName());
        });
        return planCategories;
    }

    @Override
    public boolean createPlan(Plan plan) {
        Plan data = planRepo.save(plan);
        return data != null;
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepo.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> optionalPlan = planRepo.findById(planId);
        return optionalPlan.orElse(null);
    }

    @Override
    public boolean delete(Integer planId) {
        try {
            planRepo.deleteById(planId);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePlan(Plan plan) {
        planRepo.save(plan);
        return plan.getPlanId() != null;
    }

    @Override
    public boolean enableDisablePlan(Integer planId, Boolean IsEnableDisable) {
        Optional<Plan> optionalPlan = planRepo.findById(planId);
        if (optionalPlan.isPresent()) {
            Plan plan = optionalPlan.get();
            plan.setActiveSwitch(IsEnableDisable);
        }
        return false;
    }

}
