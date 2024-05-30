package com.rafaelrodrigues1.desafios.loans.infrastructure.adapters.out.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class ConfigProperties {

    @Value("#{'${default.states.loans}'.split(',')}")
    private List<String> defaultStates;
}
