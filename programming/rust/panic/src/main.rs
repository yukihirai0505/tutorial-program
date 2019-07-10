fn main() {
    // panic!("Crash and burn!");
    let v = vec![1, 2, 3];
    v[99]; // we can see the stack trace from setting -> export `RUST_BACKTRACE=1` at the command line
}
