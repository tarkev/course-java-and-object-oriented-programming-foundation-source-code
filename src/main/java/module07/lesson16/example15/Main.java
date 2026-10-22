package module07.lesson16.example15;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Ticket> tickets = List.of(
                new Ticket("Java Meetup", LocalDate.of(2026, 11, 2), 50000, new Standard()),
                new Ticket("Java Meetup", LocalDate.of(2026, 11, 2), 50000, new Student("BUET")),
                new Ticket("Spring Workshop", LocalDate.of(2026, 11, 2), 120000, new Vip(30000)),
                new Ticket("Java Meetup", LocalDate.of(2026, 11, 3), 50000, new Standard()),
                new Ticket("Spring Workshop", LocalDate.of(2026, 11, 3), 120000, new Standard()),
                new Ticket("Cloud Day", LocalDate.of(2026, 11, 3), 80000, new Student("DU")),
                new Ticket("Java Meetup", LocalDate.of(2026, 11, 4), 50000, new Vip(20000)));

        TicketReport report = new TicketReport(tickets);
        TicketReport empty = new TicketReport(List.of());

        System.out.println("Tickets per day: " + report.ticketsPerDay());
        System.out.println("Best-selling event: "
                + report.bestSellingEvent().orElse("none"));
        System.out.println("Best-selling with no sales: "
                + empty.bestSellingEvent().orElse("none"));
        System.out.println("Revenue by event: " + report.revenueByEvent());
        System.out.println("Total revenue: " + report.totalRevenue() + " paisa");
        System.out.println(tickets.get(1).typeLabel() + ": "
                + tickets.get(1).priceInPaisa() + " paisa");
        System.out.println(tickets.get(2).typeLabel() + ": "
                + tickets.get(2).priceInPaisa() + " paisa");
    }
}

sealed interface TicketType permits Standard, Student, Vip {
}

record Standard() implements TicketType {
}

record Student(String institution) implements TicketType {
}

record Vip(long loungeFeeInPaisa) implements TicketType {
}

record Ticket(String event, LocalDate saleDate, long basePriceInPaisa,
        TicketType type) {

    Ticket {
        if (event == null || event.isBlank()) {
            throw new IllegalArgumentException("Event name is required.");
        }
        if (saleDate == null || type == null) {
            throw new IllegalArgumentException("Sale date and type are required.");
        }
        if (basePriceInPaisa <= 0) {
            throw new IllegalArgumentException("Base price must be positive.");
        }
        event = event.strip();
    }

    long priceInPaisa() {
        return switch (type) {
            case Standard standard -> basePriceInPaisa;
            case Student student -> basePriceInPaisa * 80 / 100;
            case Vip vip -> basePriceInPaisa + vip.loungeFeeInPaisa();
        };
    }

    String typeLabel() {
        return switch (type) {
            case Standard standard -> "Standard";
            case Student(String institution) -> "Student (" + institution + ")";
            case Vip(long loungeFeeInPaisa) -> "VIP (+" + loungeFeeInPaisa + " lounge)";
        };
    }
}

record TicketReport(List<Ticket> tickets) {

    TicketReport {
        tickets = List.copyOf(tickets);
    }

    Map<LocalDate, Long> ticketsPerDay() {
        return tickets.stream()
                .collect(Collectors.groupingBy(
                        Ticket::saleDate, TreeMap::new, Collectors.counting()));
    }

    Optional<String> bestSellingEvent() {
        Map<String, Long> countsByEvent = tickets.stream()
                .collect(Collectors.groupingBy(
                        Ticket::event, TreeMap::new, Collectors.counting()));

        return countsByEvent.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

    Map<String, Long> revenueByEvent() {
        ConcurrentHashMap<String, Long> totals = new ConcurrentHashMap<>();

        try (ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor()) {
            for (Ticket ticket : tickets) {
                executor.submit(() ->
                        totals.merge(ticket.event(), ticket.priceInPaisa(), Long::sum));
            }
        }

        return new TreeMap<>(totals);
    }

    long totalRevenue() {
        return tickets.stream().mapToLong(Ticket::priceInPaisa).sum();
    }
}
