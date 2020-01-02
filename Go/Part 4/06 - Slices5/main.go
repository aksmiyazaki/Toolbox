package main

import "fmt"

func main() {
	x := []int{1, 2, 3, 8, 42}
	fmt.Println(x)

	x = append(x[:2], x[3:]...)
	fmt.Println(x)
}
