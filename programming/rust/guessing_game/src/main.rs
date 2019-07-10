extern crate rand;

use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn main() {
    println!("Welcom to the guessing game!");
    let secret_number = rand::thread_rng().gen_range(1, 101);
    // println!("Secret number is = {}", secret_number);

    loop {
        println!("plz input your guess..");
        let mut guess = String::new();
        io::stdin()
            .read_line(&mut guess)
            .expect("failed to read line!");

        println!("You guessed: {}", guess);
        let guess: u32 = guess.trim().parse().expect("Type a number!");
        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too samll"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
