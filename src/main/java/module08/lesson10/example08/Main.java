package module08.lesson10.example08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        ParcelStore store = new ParcelStore();
        store.save(new Parcel("PKG-1001", ParcelStatus.CREATED, "Warehouse"));
        store.save(new Parcel("PKG-1002", ParcelStatus.CREATED, "Warehouse"));
        TrackingHandler handler = new TrackingHandler(new TrackingService(store));

        System.out.println(handler.update("PKG-1001", "in_transit", "Dhaka hub"));
        System.out.println(handler.update("PKG-1001", " out_for_delivery ", "Mirpur"));
        System.out.println(handler.update("PKG-1001", "DELIVERED", "Mirpur"));
        System.out.println(handler.update("PKG-1001", "IN_TRANSIT", "Dhaka hub"));
        System.out.println(handler.update(" ", "flying", null));
        System.out.println(handler.update("PKG-9999", "", "Dhaka hub"));
        store.failSaves();
        System.out.println(handler.update("PKG-1002", "IN_TRANSIT", "Khulna hub"));
        System.out.println(String.join("\n", handler.logEntries()));
    }
}

enum ParcelStatus {
    CREATED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED;

    boolean canMoveTo(ParcelStatus target) {
        return switch (this) {
            case CREATED -> target == IN_TRANSIT;
            case IN_TRANSIT -> target == OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY -> target == DELIVERED || target == IN_TRANSIT;
            case DELIVERED -> false;
        };
    }

    static Optional<ParcelStatus> fromText(String text) {
        String normalized = text == null ? "" : text.strip().toUpperCase();
        for (ParcelStatus status : values()) {
            if (status.name().equals(normalized)) {
                return Optional.of(status);
            }
        }
        return Optional.empty();
    }
}

abstract class ParcelException extends RuntimeException {
    ParcelException(String message, Throwable cause) {
        super(message, cause);
    }
}

final class ParcelValidationException extends ParcelException {
    ParcelValidationException(List<String> errors) {
        super("Update rejected: " + String.join(", ", errors) + ".", null);
    }
}

final class InvalidTransitionException extends ParcelException {
    InvalidTransitionException(String code, ParcelStatus from, ParcelStatus to) {
        super("Parcel " + code + " cannot move from " + from + " to " + to + ".", null);
    }
}

final class TrackingStoreException extends ParcelException {
    TrackingStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}

record Parcel(String trackingCode, ParcelStatus status, String location) {
    Parcel movedTo(ParcelStatus target, String newLocation) {
        if (!status.canMoveTo(target)) {
            throw new InvalidTransitionException(trackingCode, status, target);
        }
        return new Parcel(trackingCode, target, newLocation);
    }
}

final class ParcelStore {
    private final Map<String, Parcel> parcels = new HashMap<>();
    private boolean diskFull;

    void failSaves() {
        diskFull = true;
    }

    Optional<Parcel> find(String trackingCode) {
        return Optional.ofNullable(parcels.get(trackingCode));
    }

    void save(Parcel parcel) throws IOException {
        if (diskFull) {
            throw new IOException("Disk is full");
        }
        parcels.put(parcel.trackingCode(), parcel);
    }
}

final class TrackingService {
    private final ParcelStore store;

    TrackingService(ParcelStore store) {
        this.store = store;
    }

    Parcel update(String code, String status, String location) {
        List<String> errors = new ArrayList<>();
        Optional<Parcel> parcel = store.find(code == null ? "" : code.strip());
        if (code == null || code.isBlank()) {
            errors.add("tracking code is required");
        } else if (parcel.isEmpty()) {
            errors.add("no parcel with tracking code " + code.strip());
        }
        Optional<ParcelStatus> target = ParcelStatus.fromText(status);
        if (target.isEmpty()) {
            errors.add(status == null || status.isBlank()
                    ? "status is required" : "unknown status '" + status.strip() + "'");
        }
        if (location == null || location.isBlank()) {
            errors.add("location is required");
        }
        if (!errors.isEmpty()) {
            throw new ParcelValidationException(errors);
        }

        Parcel moved = parcel.orElseThrow().movedTo(
                target.orElseThrow(), location.strip());
        try {
            store.save(moved);
        } catch (IOException exception) {
            throw new TrackingStoreException(
                    "Could not save parcel " + moved.trackingCode() + ".", exception);
        }
        return moved;
    }
}

final class TrackingHandler {
    private final TrackingService service;
    private final List<String> log = new ArrayList<>();

    TrackingHandler(TrackingService service) {
        this.service = service;
    }

    String update(String code, String status, String location) {
        try {
            Parcel parcel = service.update(code, status, location);
            return parcel.trackingCode() + " is now " + parcel.status()
                    + " at " + parcel.location() + ".";
        } catch (ParcelValidationException | InvalidTransitionException exception) {
            return exception.getMessage();
        } catch (TrackingStoreException exception) {
            return "Tracking is unavailable. Reference: "
                    + logged(exception) + ".";
        } catch (RuntimeException exception) {
            return "Something went wrong. Reference: " + logged(exception) + ".";
        }
    }

    List<String> logEntries() {
        return List.copyOf(log);
    }

    private String logged(Exception exception) {
        String reference = "ERR-" + (log.size() + 1);
        String entry = reference + " " + exception;
        for (Throwable cause = exception.getCause(); cause != null;
                cause = cause.getCause()) {
            entry = entry + "\n  caused by: " + cause;
        }
        log.add(entry);
        return reference;
    }
}
