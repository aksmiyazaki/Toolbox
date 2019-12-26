package main

import "fmt"

var y string

func main() {
	fmt.Println("Value of Y: ", y)
	fmt.Printf("%T\n", y)

	y = "potato"
	fmt.Println("Value of Y: ", y)
	fmt.Printf("%T\n", y)
}
