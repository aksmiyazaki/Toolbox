package main

import "fmt"

func main() {
	fmt.Println(foo())

	v := bar()
	fmt.Println(v())
}

func foo() string {
	s1 := "Hello World"
	return s1
}

func bar() func() int {
	return func() int {
		return 451
	}
}
