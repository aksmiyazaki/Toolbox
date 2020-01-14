package main

import "testing"

func TestMySum(t *testing.T) {
	if MySum(2, 3) != 5 {
		t.Error("Expected 5 got", MySum(2, 3))
	}
}
