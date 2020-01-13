package main

import (
	"fmt"
	"sync"
)

func main() {
	c := make(chan int)
	var wg sync.WaitGroup
	wg.Add(2)

	go gen(c, &wg)
	go receive(c, &wg)

	wg.Wait()

	fmt.Println("about to exit")
}

func gen(cg chan<- int, w *sync.WaitGroup) {
	for i := 0; i < 10; i++ {
		cg <- i
	}
	close(cg)
	w.Done()
}

func receive(cr <-chan int, w *sync.WaitGroup) {
	for v := range cr {
		fmt.Println("Received", v)
	}
	w.Done()
}
