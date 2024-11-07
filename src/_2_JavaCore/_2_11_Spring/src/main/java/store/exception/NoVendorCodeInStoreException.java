package store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoVendorCodeInStoreException extends IllegalArgumentException {
    public NoVendorCodeInStoreException(String s) {
        super(s);
    }
}
