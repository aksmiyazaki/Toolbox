package main

import "fmt"

func main() {
	x := []int{1, 2, 3, 8, 42}
	fmt.Println(x)

	x = append(x, 99, 50, 42)
	fmt.Println(x)

	y := []int{0, 65}
	/// ... expands the values of the variable y.
	x = append(x, y...)

	fmt.Println(x)
}
