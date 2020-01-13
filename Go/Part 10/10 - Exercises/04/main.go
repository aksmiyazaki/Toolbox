package main

import (
	"fmt"
	"sync"
)

func main() {
	c := make(chan int)
	q := make(chan bool)
	var wg sync.WaitGroup

	wg.Add(1)

	go gen(c, q)

	receive(c, q)
	wg.Done()
	wg.Wait()

	fmt.Println("about to exit")
}

func gen(c chan<- int, q chan<- bool) {
	for i := 0; i < 10; i++ {
		c <- i
	}
	q <- true
	close(c)
	close(q)
}

func receive(r <-chan int, q <-chan bool) {
	for {
		select {
		case msg1, ok := <-r:
			if ok {
				fmt.Println("Value: ", msg1)
			}
		case msg1, ok := <-q:
			if ok && msg1 {
				fmt.Println("Requested to exit")
				return
			}
		}
	}
}
