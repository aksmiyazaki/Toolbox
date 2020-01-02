package main

import "fmt"

var x int // package level scope

func main() {
	var y int = 10 // function level scope

	fmt.Println(x)
	x++
	fmt.Println(x)
	fmt.Println(x)
	foo()

	fmt.Println(y)

	{
		z := 10
		fmt.Println(z) // Code block level scope
	}

	a := incrementor()
	fmt.Println(a())
	fmt.Println(a())

	b := incrementor()
	fmt.Println(b())
	fmt.Println(b())
	fmt.Println(b())
}

func incrementor() func() int {
	var x int
	return func() int {
		x++
		return x
	}
}

func foo() {
	x++
	fmt.Println(x)
}
