package main

import "fmt"

func main() {
	c := make(chan int, 2)
	c <- 42

	fmt.Printf("%T\n", c)
	fmt.Println("----------------")

	c2 := make(chan<- int, 2)
	c2 <- 42
	//fmt.Println(<-c2) can't do that

	fmt.Printf("%T\n", c2)
	fmt.Println("----------------")

	c3 := make(<-chan int, 2)
	//c3 <- 42 cant do this
	//fmt.Println(<-c3)

	fmt.Printf("%T\n", c3)
	fmt.Println("----------------")

}
