#include <iostream>
#include <vector>

// other function style
int square1(int x) {
    return x * x;
}

auto square(int x) -> int {
    return x * x;
}

// no return
void disp(const std::string& s) {
    std::string buf = "disp: " + s + "\n";
    printf(buf.c_str());
}

int abs1(int x) {
    if (x >= 0) {
        return x;
    }
    return -x;
}

int abs(int x) {
    return x >= 0 ? x : -x;
}

template <class T>

std::string to_str(T t) {
    return std::to_string(t);
}

int main() {

    /*
     * comment
     */
    std::cout << "Hello, World!" << std::endl; // comment
    const int              a = square(3);
    const std::string      s = "abc";
    std::cout << a << std::endl;
    disp("Hello World");

    int one = 1;
    int& b = one;
    b = 2;
    disp(to_str(one));
    disp(to_str(abs(-3)));

    const std::vector<int> v = {1, 2, 3};

    // normal
    for (int i = 0; i < v.size(); ++i) {
        disp(to_str(v[i]));
    }

    // simple
    for (const int x: v) {
        disp(to_str(x));
    }

    return 0;
}