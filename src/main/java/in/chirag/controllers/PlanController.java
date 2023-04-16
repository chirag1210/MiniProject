package in.chirag.controllers;

import in.chirag.constants.AppConstants;
import in.chirag.entities.Plan;
import in.chirag.props.AppProperties;
import in.chirag.services.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlanController {

    private Logger logger = LoggerFactory.getLogger(PlanController.class);

    private PlanService planService;

    private Map<String, String> messages;

    public PlanController(AppProperties appProperties, PlanService planService) {
        this.messages = appProperties.getMessages();
        this.planService = planService;
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer, String>> getPlanCategories() {
        logger.info("==>get categories started");
        return new ResponseEntity<>(planService.getPlanCategories(), HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> createPlan(@RequestBody Plan plan) {
        boolean isSaved = planService.createPlan(plan);
        String msg = AppConstants.EMPTY_STR;
        if (isSaved) {
            msg = messages.get(AppConstants.PLAN_SAVE_SUCC);
        } else {
            msg = messages.get(AppConstants.PLAN_SAVE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> getAllPlan() {
        logger.info("get All plans");
        return new ResponseEntity<>(planService.getAllPlan(), HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId) {
        return new ResponseEntity<>(planService.getPlanById(planId), HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
        String msg = AppConstants.EMPTY_STR;
        boolean isSaved = planService.updatePlan(plan);
        if (isSaved) {
            msg = messages.get(AppConstants.PLAN_UPDATE_SUCC);
        } else {
            msg = messages.get(AppConstants.PLAN_UPDATE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlanById(@PathVariable Integer planId) {
        boolean isDeleted = planService.delete(planId);
        String msg = "";
        if (isDeleted) {
            msg = messages.get(AppConstants.PLAN_DELETE_SUCC);
        } else {
            msg = messages.get(AppConstants.PLAN_DELETE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}/{isStatus}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable boolean isStatus) {
        boolean isStatusChanged = planService.enableDisablePlan(planId, isStatus);
        String msg = AppConstants.EMPTY_STR;
        if (isStatusChanged) {
            msg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
        } else {
            msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
