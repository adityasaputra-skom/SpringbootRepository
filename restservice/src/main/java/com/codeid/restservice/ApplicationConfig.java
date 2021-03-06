package com.codeid.restservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.codeid.restservice.entities.Item;
import com.codeid.restservice.entities.Stock;
import com.codeid.restservice.entities.Unit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public List<Item> itemsBean() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Kentang"));
        items.add(new Item(2, "KentangDulu"));
        items.add(new Item(3, "KentangLagi"));
        items.add(new Item(4, "KentangTerus"));
        items.add(new Item(5, "KentangMulu"));

        for (Item item : items) {
            
            item.setCreatedDate(LocalDateTime.now());
        }

        return items;
    }
    @Bean
    public List<Unit> UnitBean() {
        List<Unit> units = new ArrayList<>();
        units.add(new Unit(1, "kg"));
        units.add(new Unit(2, "kg"));
        units.add(new Unit(3, "kg"));
        units.add(new Unit(4, "kg"));
        units.add(new Unit(5, "kg"));
        
        for (Unit unit : units) {
            unit.setCreatedDate(LocalDateTime.now());
        }
        return units;
    }

    @Bean
    public List <Stock> stocksBean(@Qualifier ("itemsBean") List<Item> items, List<Unit> units) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(6, units.get(2), items.get(1)));

        return stocks;
    }
}