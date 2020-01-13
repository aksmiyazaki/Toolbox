package main

import (
	"fmt"
	"runtime"
	"sync"
	"sync/atomic"
)

func main() {
	counter := 0
	goRoutineNo := 100
	var wg sync.WaitGroup
	var mtx sync.Mutex

	wg.Add(goRoutineNo)

	for i := 0; i < goRoutineNo; i++ {
		go func() {
			mtx.Lock()
			v := counter
			v++
			runtime.Gosched()
			counter = v
			mtx.Unlock()
			wg.Done()
		}()
	}

	wg.Wait()
	fmt.Println(counter)

	wg.Add(goRoutineNo)
	counter = 0
	counter64 := int64(counter)
	for i := 0; i < goRoutineNo; i++ {
		go func() {
			runtime.Gosched()
			atomic.AddInt64(&counter64, 1)
			wg.Done()
		}()
	}

	wg.Wait()
	fmt.Println(counter64)
}
