package module11.lesson06.example01.storage;

public final class StoredDataCorruptionException extends StorageException {

    public StoredDataCorruptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
