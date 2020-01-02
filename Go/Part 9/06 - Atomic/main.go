package main

import "fmt"

import "runtime"

import "sync"

import "sync/atomic"

func main() {
	var counter int64 = 0
	const gs = 100

	fmt.Println("CPUs: ", runtime.NumCPU())
	fmt.Println("GoRout: ", runtime.NumGoroutine())

	var wg sync.WaitGroup
	wg.Add(gs)

	for i := 0; i < gs; i++ {
		go func() {
			atomic.AddInt64(&counter, 1)
			fmt.Println("Counter\t", atomic.LoadInt64(&counter))
			runtime.Gosched()
			wg.Done()
		}()
	}
	wg.Wait()
	fmt.Println("GoRout: ", runtime.NumGoroutine())
	fmt.Println(counter)
}
