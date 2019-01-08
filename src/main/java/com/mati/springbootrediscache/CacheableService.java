package com.mati.springbootrediscache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheableService {

    @Cacheable(value = "longcache", key = "#id")
    public Rational veryLongComputation(int id) {
        log.info("Computing {}", id);
        return new Rational(id, -id);
    }
}
