package acdc

func MySum(arr ...int) int {
	s := 0
	for _, v := range arr {
		s += v
	}
	return s
}

