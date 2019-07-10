#[derive(Debug)]
enum IpAddrKing {
    V4(String),
    V6(String),
}

enum Message {
    Quite,
    Move {x: i32, y: i32},
    Write(String),
    ChangeColor(i32, i32, i32),
}

impl Message {
    fn call(&self) {
        println!("I'm inside Call!");
    }
}

fn main() {
    let home = IpAddrKing::V4(String::from("127.0.0.1"));
    let loopback = IpAddrKing::V6(String::from("::1"));

    println!("{:?}", home);
    println!("{:?}", loopback);

    let m = Message::Write(String::from("hello"));
    m.call();
}
