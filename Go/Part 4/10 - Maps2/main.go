package main

import "fmt"

func main() {
	m := map[string]int{
		"James":    32,
		"Miss Blá": 44,
	}
	fmt.Println(m)

	fmt.Println(m["James"])
	fmt.Println(m["Potato"])

	v, ok := m["Potato"]
	fmt.Println(v, ok)

	if v, ok := m["tomato"]; ok {
		fmt.Println("VALUE IS OK", v)
	}

	m["Tomato"] = 34
	fmt.Println(m)

	for k, v := range m {
		fmt.Println(k, "\t", v)
	}
}
