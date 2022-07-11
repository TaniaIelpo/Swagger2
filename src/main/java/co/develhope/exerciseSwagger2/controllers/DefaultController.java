package co.develhope.exerciseSwagger2.controllers;

/**
 * @uthor Tania Ielpo
 */

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class DefaultController {

    @GetMapping("")
    @ApiOperation(value="Says hello",
            notes="Prints out the hello message for someone who visit localhost:5050" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code=400, message = "BAD DATA INPUT"),
            @ApiResponse(code=500, message = "INTERNAL ERROR FROM SPRING", response = String.class),
            @ApiResponse(code=202, message = "Created")
    })
    public String sayHello(){
        return "Welcome Here";
    }
}
