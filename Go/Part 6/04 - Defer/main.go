package main

import "fmt"

func main() {
	defer foo() // runs function after the enclosing function is exited.
	bar()
}

func foo() {
	fmt.Println("Foo")
}

func bar() {
	fmt.Println("bar")
}
