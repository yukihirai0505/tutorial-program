fn main() {
    let name = String::from("ram");
    print_character_at_position(name.clone(), 2);
    print_character_at_position(name.clone(), 4);
}

fn print_character_at_position(name: String, position: usize) {
    println!(
        "character at position {} is: {}",
        position,
        match name.chars().nth(position) {
            Some(c) => c.to_string(),
            None => "No character found".to_string(),
        }
    );
}
