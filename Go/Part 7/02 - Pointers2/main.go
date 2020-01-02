package main

import "fmt"

func main() {
	x := 0
	foo2(&x)
	fmt.Println(x)
}

func foo(y int) {
	fmt.Println(y)
	y = 43
	fmt.Println(y)
}

func foo2(y *int) {
	fmt.Println(*y)
	*y = 46
	fmt.Println(*y)
}
