package main

import (
	"fmt"
	"sync"
)

func main() {
	var wg sync.WaitGroup
	wg.Add(2)

	go func() {
		fmt.Println("Potato Tomato")
		wg.Done()
	}()

	go func() {
		fmt.Println("ASDFGASDGASDF")
		wg.Done()
	}()

	fmt.Println("Waiting")
	wg.Wait()
	fmt.Println("Everything is done")
}
