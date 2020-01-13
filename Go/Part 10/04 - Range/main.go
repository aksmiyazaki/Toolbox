package main

import "fmt"

func main() {
	c := make(chan int)

	// send
	go foo(c)

	// receive
	for v := range c { // ranges til the channel is closed
		fmt.Println(v)
	}

	fmt.Println("Done!")
}

//send
func foo(c chan<- int) {
	for i := 0; i < 100; i++ {
		c <- i
	}
	close(c) // must close otherwise, deadlock.
}
