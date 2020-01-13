package main

import (
	"fmt"
)

func main() {
	c := make(chan int)

	go func(c chan<- int) {
		c <- 42
	}(c)

	v, ok := <-c
	fmt.Println(v, ok)

	close(c)

	v, ok = <-c
	fmt.Println(v, ok)
}
