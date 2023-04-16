package in.chirag.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;

@Entity
@Data
public class PlanCategory {

    @Id
    @GeneratedValue
    private Integer planCategoryID;
    private String planCategoryName;
    private Boolean activeSwitch;
    private String createdBy;
    private String updatedBy;

    @CreationTimestamp
    private LocalDate createdDate;

    @UpdateTimestamp
    private LocalDate updatedDate;
}
