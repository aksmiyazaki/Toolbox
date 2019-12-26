package main

import "fmt"

func main() {
	x := 83 % 40
	y := 83 / 40
	fmt.Println(x, y)

	x = 0
	for x < 100 {
		x++
		if x%2 != 0 {
			continue
		}
		fmt.Println(x)
	}
}
