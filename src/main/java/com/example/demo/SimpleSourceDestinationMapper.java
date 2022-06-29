package com.example.demo;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.math.BigDecimal;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,
        builder = @Builder(disableBuilder = true))
public interface SimpleSourceDestinationMapper {
    @Mapping(target = "roundingDiff", source = "source.roundingDifference")
    SimpleDestination sourceToDestination(SimpleSource source);

    // -- default methods
    default Long mapAmount(BigDecimal amount) {
        return amount.movePointRight(2).longValue();
    }
}
