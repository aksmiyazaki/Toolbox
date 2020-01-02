package main

import "fmt"

func main() {
	f := func() {
		fmt.Println("This is a func")
	}

	f()

	g := func(x int) {
		fmt.Println("This is the current year", x)
	}

	g(2019)
}
