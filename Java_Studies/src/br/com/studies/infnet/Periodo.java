package br.com.studies.infnet;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.Optional;

public class Periodo {

    private LocalDateTime begin;
    private Optional<LocalDateTime> end;

    public Periodo(LocalDateTime begin, LocalDateTime end) {
        this.begin = begin;
        this.end = Optional.of(end);
    }

    public Periodo(LocalDateTime begin) {
        this.begin = begin;
        this.end = Optional.empty();
    }

    public Temporal getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public Optional<LocalDateTime> getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = Optional.of(end);
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}