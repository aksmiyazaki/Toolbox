package main

import (
	"fmt"
)

func main() {
	cs := make(chan int)

	go func(csf chan<- int) {
		csf <- 42
	}(cs)
	fmt.Println(<-cs)

	fmt.Printf("------\n")
	fmt.Printf("cs\t%T\n", cs)
}
