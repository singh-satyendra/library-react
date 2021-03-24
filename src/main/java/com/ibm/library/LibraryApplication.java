package com.ibm.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.samplers.ConstSampler;

//@EnableCircuitBreaker is what tells Spring Hystrix (layer on top of netflix hystrix) to search our code 
//for methods annotated with @HystrixCommand


@SpringBootApplication
@EnableCircuitBreaker
//@EnableAutoConfiguration
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	
	@Bean // Jaegar Tracer bean
	public io.opentracing.Tracer jaegerTracer() {
		SamplerConfiguration samplerConfig = 	SamplerConfiguration.fromEnv().withType(ConstSampler.TYPE).withParam(1);
		ReporterConfiguration reporterConfig = 	ReporterConfiguration.fromEnv().withLogSpans(true);
		return new Configuration("library-service")
			.withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	//We make a instance in a spring bean
	@Bean
	public WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}
}
