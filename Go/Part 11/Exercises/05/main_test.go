package main

import "testing"

func TestFoo(t *testing.T) {
	got := foo(2, 3)

	if got != 5 {
		t.Errorf("Invalid return %v", got)
	}
}
