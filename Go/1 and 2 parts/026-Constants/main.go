package main

import "fmt"

// Constants can have types or be constants of
const (
	a int = 42
	b     = 42.24
	c     = "Potato"
)

func main() {
	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	fmt.Printf("%T\n", a)
	fmt.Printf("%T\n", b)
	fmt.Printf("%T\n", c)
}
