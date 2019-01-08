package com.mati.springbootrediscache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SpringBootRedisCacheApplication implements CommandLineRunner {

	private final CacheableService cacheableService;
	private final CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Optional.ofNullable(cacheManager.getCache("longcache")).ifPresent(Cache::clear);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(()->log.info("2: computed {}", cacheableService.veryLongComputation(6)), 0, 30, TimeUnit.SECONDS);
	}
}

