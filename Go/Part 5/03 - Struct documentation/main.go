package main

import "fmt"

var x, y int

func main() {
	x = 42
	y = 33
	fmt.Println(x, y)

	x, y = y, x
	fmt.Println(x, y)
}
