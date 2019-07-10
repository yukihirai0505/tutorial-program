fn main() {

    let user1 = build_user(String::from("example@xyz.com"), String::from("user1"));

    println!("{}", user1.email);

    let user2 = User {
        email: String::from("user2@abc.com"),
        username: String::from("user2"),
        ..user1
    };

    println!("{}, {}, {}, {}", user2.email, user2.username, user2.active, user2.sign_in_count);
}

struct User {
    username: String,
    email: String,
    sign_in_count: u64,
    active: bool,
}

fn build_user (email: String, username: String) -> User {
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}