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
public class Plan {

   @Id
   @GeneratedValue
   private Integer planId;

   private String planName;
   private LocalDate planStartDate;
   private LocalDate planEndDate;
   private Integer planCategoryId;
   private Boolean activeSwitch;
   private String planCreatedBy;
   private String planUpdatedBy;

   @CreationTimestamp
   private LocalDate createdDate;
   @UpdateTimestamp
   private LocalDate updatedDate;
}
