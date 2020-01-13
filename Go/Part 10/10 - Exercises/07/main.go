package main

import "math/rand"

import "fmt"

import "sync"

var prodwg sync.WaitGroup
var wg sync.WaitGroup

func main() {
	c := make(chan int)
	prodwg.Add(10)
	wg.Add(1)

	for i := 0; i < 10; i++ {
		go prod(c)
	}

	go recv(c)

	prodwg.Wait()
	close(c)
	wg.Wait()
	fmt.Println("Everything is ok!")
}

func prod(c chan<- int) {
	defer prodwg.Done()
	for i := 0; i < 10; i++ {
		v := rand.Intn(100)
		fmt.Println("Put", v, "into channel")
		c <- v
	}
}

func recv(c <-chan int) {
	defer wg.Done()
	for {
		v, ok := <-c
		if !ok {
			fmt.Println("Returning.")
			return
		}
		fmt.Println("Removing from channel: ", v)
	}
}
