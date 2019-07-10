fn main() {
    println!("Hello, world!");
    another_function();
    another_function2(10);
    let a = sum(2, 3);
    another_function2(a);
}

fn another_function() {
    println!("Another function.");
}

fn another_function2(x:i32) {
    println!("The value of x = {}", x);
}

fn sum(x:i32, y:i32) -> i32 {
    x + y
}