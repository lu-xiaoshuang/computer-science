/*
 * Copyright (C) 2018 Xiaoshuang LU
 * All rights reserved.
 */

package main

// import "fmt"

import
(
    "fmt"
)

// go run array.go
// go build array.go && ./array

func main() {
    {
        handle_fixed_size_array()
        handle_dynamic_size_array()
    }
}

func handle_fixed_size_array() {
    fmt.Println("handle_fixed_size_array prologue");
    {
        // fixed length array
        var var_array_int64 [2]int64 = [2]int64 { 1, 1 }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    {
        // fixed length array
        var var_array_int64 [2][2]int64 = [2][2]int64 { { 1, 1 }, { 1, 1 } }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    fmt.Println("handle_fixed_size_array epilogue");
}

func handle_dynamic_size_array() {
    fmt.Println("handle_dynamic_size_array prologue");
    {
        // dynamic length array
        var var_array_int64 []int64 = []int64 { 1, 1 }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
        var_array_int64 = append(var_array_int64, 1)
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    {
        // dynamic length array
        var var_array_int64 [][]int64 = [][]int64 { { 1, 1 }, { 1, 1 } }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    {
        // dynamic length array
        var var_array_int64 [2][]int64 = [2][]int64 { { 1, 1 }, { 1, 1 } }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    {
        // dynamic length array
        var var_array_int64 [][2]int64 = [][2]int64 { { 1, 1 }, { 1, 1 } }
        fmt.Println("%T %v", var_array_int64, var_array_int64)
    }
    fmt.Println("handle_dynamic_size_array epilogue");
}
