package main

import (
	"fmt"
	"runtime"
	"sync"
)

func main() {
	counter := 0
	goRoutineNo := 100
	var wg sync.WaitGroup

	wg.Add(goRoutineNo)

	for i := 0; i < goRoutineNo; i++ {
		go func() {
			v := counter
			v++
			runtime.Gosched()
			counter = v
			wg.Done()
		}()
	}

	wg.Wait()
	fmt.Println(counter)
}
