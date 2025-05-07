package module4;

/**
 * 自定义 非法年龄 异常类
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidAgeException(Throwable cause) {
        super(cause);
    }

    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAgeException(String message) {
        super(message);
    }

    public InvalidAgeException() {
        super("年龄不合法");
    }
}
