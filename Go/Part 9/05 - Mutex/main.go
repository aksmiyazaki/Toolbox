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
	var mtx sync.Mutex
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		go func() {
			mtx.Lock()
			v := counter
			runtime.Gosched()
			v++
			counter = v
			mtx.Unlock()
			wg.Done()
		}()
	}
	wg.Wait()
	fmt.Println("GoRout: ", runtime.NumGoroutine())
	fmt.Println(counter)
}
