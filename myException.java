import java.io.IOException;

public class myException extends IOException {

    private static final long serialversionUID = 452775372;
    private String errorCode = "fugguuuu exception";
    public myException(String message,String errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode(){
        return this.errorCode;
    }

}
