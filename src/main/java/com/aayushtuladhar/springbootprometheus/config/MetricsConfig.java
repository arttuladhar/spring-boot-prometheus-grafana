package com.aayushtuladhar.springbootprometheus.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

  @Bean
  MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {

    return registry -> registry.config()
        .commonTags("application", "Demo-App")
        .commonTags("instance", "Demo-Instance");
  }

}
