package main

import "fmt"

import "runtime"

import "sync"

func main() {
	counter := 0
	const gs = 100

	fmt.Println("CPUs: ", runtime.NumCPU())
	fmt.Println("GoRout: ", runtime.NumGoroutine())

	var wg sync.WaitGroup
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		go func() {
			v := counter
			runtime.Gosched()
			v++
			counter = v
			wg.Done()
		}()
	}
	wg.Wait()
	fmt.Println("GoRout: ", runtime.NumGoroutine())
	fmt.Println(counter)
}
