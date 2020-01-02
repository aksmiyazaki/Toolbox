package main

import "fmt"

func main() {
	m := map[string]int{
		"James":    32,
		"Miss Blá": 44,
	}
	fmt.Println(m)
	delete(m, "James")
	delete(m, "Non ecxiste")

	fmt.Println(m)

	if v, ok := m["James"]; ok {
		delete(m, "James")
		fmt.Println(v)
	}

}
