package main

import "fmt"

func main() {
	fmt.Println("Potato potato tomato")
	foo()
	fmt.Println("Back from foo")

	for i := 0; i < 100; i++ {
		if i%33 == 0 {
			fmt.Println("Woah")
		}
	}

	bar()
}

func foo() {
	fmt.Println("I'm foo")
}

func bar() {
	fmt.Println("Shoosh")
}
