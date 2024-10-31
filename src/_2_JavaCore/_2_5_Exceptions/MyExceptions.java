package _2_JavaCore._2_5_Exceptions;

class WrongLoginException extends IllegalArgumentException {
    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends IllegalArgumentException {
    public WrongPasswordException(String message) {
        super(message);
    }
}