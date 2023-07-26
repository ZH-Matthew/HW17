package course2_5.employeeacc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidCharactersInNameException extends RuntimeException{
    public EmployeeInvalidCharactersInNameException(){

    }
}
