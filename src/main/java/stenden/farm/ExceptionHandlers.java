package stenden.farm;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ExceptionHandlers {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFound.class)
  public ErrorResponse handleGreetingException(
          NotFound exception,
          HttpServletRequest request
  ) {
    String response = String.format(
            "I have the message '%s' for %s",
            exception.getMessage(),
            request.getRemoteAddr()
    );
    return new ErrorResponse(response);
  }

}
