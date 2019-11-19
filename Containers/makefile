setup:
	docker-compose build

run:
	docker-compose up

clean: check_clean

check_clean:
	@echo -n "If you play with docker, you may check what this command does... are you sure? [y/N] " && read ans && [ $${ans:-N} = y ]
	docker container prune -f
	docker image prune -f

.PHONY: clean check_clean

.ONESHELL:
test:
	cd ./tests
	python3 stack_tests.py
