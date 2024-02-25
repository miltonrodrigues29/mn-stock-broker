package com.milton.lseg.broker.data;

import com.github.javafaker.Faker;
import com.milton.lseg.broker.entity.Symbol;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Singleton
public class InMemoryStore {
    private final Map<String, Symbol> symbols;
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryStore.class);
    private final Faker faker = new Faker();
    public InMemoryStore() {
        this.symbols = new HashMap<>();
    }

    @PostConstruct
    public void initialize() {
        IntStream.range(0, 10).forEach(i -> addNewSymbol());
    }

    private void addNewSymbol() {
        var symbol = new Symbol(faker.stock().nsdqSymbol());
        symbols.put(symbol.value(), symbol);
        LOG.debug("Added Symbol {}", symbol);
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}
