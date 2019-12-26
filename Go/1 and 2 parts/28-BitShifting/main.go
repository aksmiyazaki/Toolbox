package main

import "fmt"

const (
	_    = iota
	i_kb = 1 << (10 * iota)
	i_mb = 1 << (10 * iota)
	i_gb = 1 << (10 * iota)
)

func main() {
	x := 4
	fmt.Printf("%d\t %b\n", x, x)

	y := x << 1
	fmt.Printf("%d\t %b\n", y, y)

	kb := 1024
	mb := kb * 1024
	gb := mb * 1024

	fmt.Printf("%d\t %b\n", kb, kb)
	fmt.Printf("%d\t %b\n", mb, mb)
	fmt.Printf("%d\t %b\n", gb, gb)

	fmt.Printf("%d\t %b\n", i_kb, i_kb)
	fmt.Printf("%d\t %b\n", i_mb, i_mb)
	fmt.Printf("%d\t %b\n", i_gb, i_gb)
}
