# Notes

Spring Boot 2 configures a composite MeterRegistry to which any number of registry implementations can be added,
allowing you to ship your metrics to more than one monitoring system. Through, MeterRegistryCustomizer,
you can customize the whole set of registries at once or individual implementations in particular.
For example, a commonly requested setup is to (1) export metrics to both Prometheus and CloudWatch,
(2) add a set of common tags to metrics flowing to both (for example, host and application identifying tags)
and (3) whitelist only a small subset of metrics to CloudWatch.

