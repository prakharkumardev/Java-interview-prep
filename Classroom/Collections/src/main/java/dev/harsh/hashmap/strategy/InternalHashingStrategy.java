package dev.harsh.hashmap.strategy;

import java.util.Objects;

public class InternalHashingStrategy implements HashingStrategy{
    @Override
    public int getHashValue(String key) {
        return Objects.hash(key);
    }
}
