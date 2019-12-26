package main

import "fmt"

var z = 45

// Declares a variable of type int
// Assigns default value (zero value) to k
var k int

func main() {
	// Short Decl
	// Declares and assign a variable with a value of a certain type
	x := 42
	fmt.Println(x)

	//var kw
	// Can declare variables outside of a function body
	var y = 43
	fmt.Println(y)

	foo()
}

func foo() {
	fmt.Println(z)
}
