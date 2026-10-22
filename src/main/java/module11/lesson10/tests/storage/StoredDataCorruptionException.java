package module11.lesson10.tests.storage;

public final class StoredDataCorruptionException extends StorageException {

    public StoredDataCorruptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
