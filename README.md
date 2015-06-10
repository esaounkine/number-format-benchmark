# number-format-benchmark
Small benchmark suite to compare some of the proposed solutions for the question
http://stackoverflow.com/questions/4753251/how-to-go-about-formatting-1200-to-1-2k-in-java/

## Benchmark output 
All methods were made static. This benchmark invoked each method 1m times to format 10 input numbers. Here are the results:

* Stefan Bachert: 4.995 seconds
* Eduardo Aviles: 4.861 seconds
* maraca: 2.914 seconds
* esaounkine: 4.75 seconds
* assylias: 3.504 seconds
* jhurtado: 25.107 seconds
* jzd: 35.481 seconds
