fn main() {
    let mut num = 5;
    println!("The value of x = {}", num);
    num = 6;
    println!("The value of x = {}", num);

    let tup: (i32, f64, u8) = (500, 3.5, 1);
    let (x, y, z) = tup;

    println!("X = {}, Y = {}, Z = {}", x, y, z);
    println!("X = {}, Y = {}, Z = {}", tup.0, tup.1, tup.2);
}
