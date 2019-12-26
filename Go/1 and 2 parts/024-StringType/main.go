package main

import "fmt"

func main() {
	x := "Hello, World!"
	fmt.Println(x)
	fmt.Printf("%T\n", x)

	bs := []byte(x)
	fmt.Println(bs)
	fmt.Printf("%T\n", bs)

	for i := 0; i < len(x); i++ {
		fmt.Printf("%#U ", x[i])
	}

	fmt.Println("")

	for i, n := range x {
		fmt.Printf("at index %d we have %x \n", i, n)
	}
}
