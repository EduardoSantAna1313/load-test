Exemplo usando [wrk2](https://github.com/giltene/wrk2). Baseado no projeto [aks-jvm-benchmark](https://github.com/brunoborges/aks-jvm-benchmark/blob/main/containers/Dockerfile.loadtest).

## Executando os testes

Basta rodar o script `test.sh`

Output:

```
Running 30s test @ http://localhost:8080/hello
  8 threads and 10 connections
  Thread calibration: mean lat.: 5942.810ms, rate sampling interval: 17334ms
  Thread calibration: mean lat.: 5916.149ms, rate sampling interval: 17137ms
  Thread calibration: mean lat.: 6204.683ms, rate sampling interval: 17481ms
  Thread calibration: mean lat.: 6086.252ms, rate sampling interval: 17678ms
  Thread calibration: mean lat.: 6136.506ms, rate sampling interval: 17203ms
  Thread calibration: mean lat.: 6162.064ms, rate sampling interval: 17661ms
  Thread calibration: mean lat.: 5882.022ms, rate sampling interval: 17334ms
  Thread calibration: mean lat.: 5955.823ms, rate sampling interval: 17104ms
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    16.50s     4.50s   27.85s    65.09%
    Req/Sec    77.50      3.97    83.00     75.00%
  Latency Distribution (HdrHistogram - Recorded Latency)
 50.000%   16.00s
 75.000%   19.74s
 90.000%   22.86s
 99.000%   26.49s
 99.900%   27.77s
 99.990%   27.84s
 99.999%   27.87s
100.000%   27.87s

  Detailed Percentile spectrum:
       Value   Percentile   TotalCount 1/(1-Percentile)

[...]

#[Mean    =    16499.257, StdDeviation   =     4497.760]
#[Max     =    27852.800, Total count    =        11145]
#[Buckets =           27, SubBuckets     =         2048]
----------------------------------------------------------
  16589 requests in 30.05s, 2.33MB read
Requests/sec:    552.08
Transfer/sec:     79.25KB
```
