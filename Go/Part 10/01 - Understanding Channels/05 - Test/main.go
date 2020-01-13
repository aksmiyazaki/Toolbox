package main

import "fmt"

import "sync"

func main() {
	c := make(chan int)
	var wg sync.WaitGroup

	wg.Add(2)

	go func() {
		for i := 0; i < 100; i++ {
			fmt.Println("Put", i)
			c <- i
		}
		wg.Done()
	}()

	go func() {
		for j := 0; j < 100; j++ {
			fmt.Println("Received", <-c)
		}
		wg.Done()
	}()

	wg.Wait()
}
