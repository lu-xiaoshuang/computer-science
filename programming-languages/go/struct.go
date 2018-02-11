package main

// import "fmt"

import
(
    "fmt"
)

// global variable
var
(
    global_var_1_int int
    global_var_2_int int
)

var global_var_3_int int

// global const
const
(
    global_const_1_int = 1
    global_const_2_int = 1
)

const global_const_3_int int = 1

// go run variable.go
// go build variable.go && ./variable

func main() {
    // var identifier type
    // var identifier type = value
    // var identifier, identifier type
    // var identifier, identifier type = value, value
    // identifier := value
    // identifier, identifier := value, value
    var var_1_int64, var_2_int64 int64 = 1, 1
    var_3_int64, var_4_int64 := 1, 1
    fmt.Println("%v %v", var_1_int64, var_2_int64)
    fmt.Println("%v %v", var_3_int64, var_4_int64)
    fmt.Println("%v %v %v", global_var_1_int, global_var_2_int, global_var_3_int)
    fmt.Println("%v %v %v", global_const_1_int, global_const_2_int, global_const_3_int)
    {
        handle_integer()
        handle_float()
    }
}

func handle_integer() {
    fmt.Println("handle_integer prologue");
    var var_int8 int8 = 1
    var var_uint8 uint8 = 1
    var var_int16 int16 = 1
    var var_uint16 uint16 = 1
    var var_int32 int32 = 1
    var var_uint32 uint32 = 1
    var var_int64 int64 = 1
    var var_uint64 uint64 = 1
    fmt.Println("%v %v", var_int8, var_uint8)
    fmt.Println("%v %v", var_int16, var_uint16)
    fmt.Println("%v %v", var_int32, var_uint32)
    fmt.Println("%v %v", var_int64, var_uint64)
    fmt.Println("handle_integer epilogue");
}

func handle_float() {
    fmt.Println("handle_float prologue");
    var var_float32 float32 = 1
    var var_float64 float64 = 1
    fmt.Println("%v", var_float32)
    fmt.Println("%v", var_float64)
    fmt.Println("handle_float epilogue");
}
