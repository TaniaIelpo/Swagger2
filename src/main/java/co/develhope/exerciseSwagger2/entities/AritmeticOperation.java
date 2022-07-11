package co.develhope.exerciseSwagger2.entities;

/**
 * @author Tania Ielpo
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AritmeticOperation {

    @ApiModelProperty(value="The name of operation", example = "sum")
    private String name;
    @ApiModelProperty(value="minimum number of operands", example = "1")
    private Integer minNumberOfOperands;
    @ApiModelProperty(value="a description about the operation", example = "sum two numbers")
    private String description;
    @ApiModelProperty(value="A list of properties of the operation", example = "[commutative property,associated property]")
    private String[] properties;
}
