package main

import "fmt"

func main() {
	foo()

	func() {
		fmt.Println("Anonyrun")
	}()

	func(x int) {
		fmt.Println("Anonyrun", x)
	}(42)
}

func foo() {
	fmt.Println("Foooooo")
}
