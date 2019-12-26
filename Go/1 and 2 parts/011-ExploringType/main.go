package main

import "fmt"

var y = 42
var z = "Potato tomato"

// raw string
var p = `testing a raw string "because I can \n\n\n"`

func main() {
	fmt.Println(y)
	fmt.Printf("%T\n", y)
	fmt.Println(z)
	fmt.Printf("%T\n", z)
	fmt.Println(p)
	// GO is statically typed.
	//z = 42
}
