package main

import "fmt"

func main() {
	x := []int{1, 2, 3, 8, 42}
	fmt.Println(x)

	for i, v := range x {
		fmt.Println(i, "\t", v)
	}

}
