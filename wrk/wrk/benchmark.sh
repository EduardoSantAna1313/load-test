# -t = threads
# -c = connections
# -d = duration
# -R = work rate in requests/sec
# --latency = Print latency statistics
wrk -t 8 -c 10 -d 30s -R 10000 --latency http://localhost:8080/hello
