package main

import "fmt"

import "sync"

var wg sync.WaitGroup

func main() {
	c := make(chan int)

	wg.Add(2)

	go prod(c)
	go recv(c)

	wg.Wait()
	fmt.Println("Program Exit!")
}

func prod(c chan<- int) {
	defer wg.Done()
	for i := 0; i < 100; i++ {
		c <- i
	}
	close(c)
}

func recv(c <-chan int) {
	defer wg.Done()
	for {
		v, ok := <-c
		if !ok {
			fmt.Println("Exiting.")
			return
		}
		fmt.Println("Here is the number:", v)
	}
}
