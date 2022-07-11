package co.develhope.exerciseSwagger2.controllers;
/**
 * @author Tania Ielpo
 */
import co.develhope.exerciseSwagger2.entities.AritmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping(value="")
    @ApiOperation(value="Says hello",
            notes="Prints out the hello message for the user who accesses at localhost:5050/math" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    public String welcomeMathMsg(){
        return "Welcome in MathController";
    }

    @GetMapping(value="/division-info")
    @ApiOperation(value="Get information of division",notes="Return information about division" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })

    public AritmeticOperation getDivisionInfo(){
        return new AritmeticOperation("Division",
                2,
                "it allows to obtain the quotient (final result) between two numbers " +
                        "called dividend and divisor. The first of the latter represents " +
                        "the quantity to be divided while the second indicates the quantity that divides.",
                new String[]{"invariant property","distributive property"});
    }

    @PostMapping("/multiplication")
    @ApiOperation(value="it multiplies 2 numbers",
            notes="returns the product of two or more Integers " +
                    "passed as an array in the body of the request example:[2,3,4,5,..]" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({

            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })

    public int multiplication(@ApiParam(value = "The operands request body")
                               @RequestBody (required = true) @Validated @Size(min=2) int[] param){

        Integer support=1;
        for (int i = 0; i < param.length; i++) {
            support=support*param[i];
        }
        return support;
    }

    @GetMapping("/square/{n}")
    @ApiOperation(value="it squares an integer passed in the path",
            notes="pass the integer to be squared in the Path example:.../square/3" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })

    public int square(@ApiParam(value="The value") @PathVariable(required = true)int n){

        return n*n;
    }
}
