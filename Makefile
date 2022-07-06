run-dist:
	./build/install/app/bin/app
build:
	./gradlew clean
	./gradlew installDist
check:
	./gradlew checkstyleMain
.PHONY: build