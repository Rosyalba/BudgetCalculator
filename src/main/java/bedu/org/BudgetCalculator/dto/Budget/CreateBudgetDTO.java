package bedu.org.BudgetCalculator.dto.Budget;


import bedu.org.BudgetCalculator.model.Client;
import bedu.org.BudgetCalculator.model.Estatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;


@Data
public class CreateBudgetDTO {

     @Schema(description = "Name of the budget", example = "Installation of security systems."
    )
    @NotBlank(message = "El campo nombre presupuesto es obligatorio")
     private String nameBudget;

     @Schema(description = "Customer ID", example = "60"
     )
    @NotNull(message = "El id del cliente es obligatorio.")
    private Client customerId;

    @Schema(description = "Total of the budget", example = "$2,500"
    )
    @PositiveOrZero(message = "El total debe ser positivo")
    @DecimalMin(value = "1.0000",message = "El total debe ser mayor a 0")
    private double total;

    @Schema(description = "Day the budget was created", example = "12/12/2023"
    )
    @NotNull(message = "La feha inicio es obligatoria")
    @FutureOrPresent(message = "La fecha inicio debe ser igual o mayor a hoy.")
    private LocalDate startDate;

    @Schema(description = "Day the activities end", example = "10/01/2024"
    )
    @NotNull(message = "La fecha fin es obligatoria")
    @Future(message = "La fecha fin debe ser mayor a hoy")
    private LocalDate endDate;

    @Schema(description = "Status of the budget", example = "created"
    )
    @NotNull(message = "Es campo Estado es obligatorio")
    private Estatus status;

    @Schema(description = "If the budget is currently active", example = "true"
    )
    private boolean Active;

    @Schema(description = "If the budget was generated", example = "true"
    )
    private boolean Generated;

    @Schema(description = "If the budget was accepted", example = "true"
    )
    private boolean Accepted;

}
