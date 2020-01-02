package main

import "fmt"

func main() {
	x := sum(2, 3, 4, 5, 6, 7, 8, 9)
	x = sum(1)

	fmt.Println(x)
}

func sum(x ...int) int {
	fmt.Println("Foooo")
	fmt.Println(x)
	fmt.Printf("%T\n", x)

	sum := 0
	for _, v := range x {
		sum += v
	}

	fmt.Println("Sum = ", sum)
	return sum
}
