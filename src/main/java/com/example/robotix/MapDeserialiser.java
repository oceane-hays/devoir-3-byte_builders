package com.example.robotix;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import java.io.IOException;

public class MapDeserialiser extends KeyDeserializer {
    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        // Remplacer par la logique réelle pour convertir une chaîne en instance de Composante
        // Par exemple, si Composante a un constructeur qui accepte une chaîne :
        return new Composante();
    }
}

