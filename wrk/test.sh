printf "### Starting the mock server ###\n"

cd app/
bash run.sh
if [[ $? == 1 ]]; then
  printf "> ERRO\n"
  exit 1;
fi

printf "\n### Running the load test with WRK2 ###\n"

cd ../wrk/
bash run-load-test.sh
