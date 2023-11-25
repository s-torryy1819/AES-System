package lr9_2.exceptions;

import org.springframework.dao.DataAccessException;

public class CustomDataAccessException extends DataAccessException {

    public CustomDataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}