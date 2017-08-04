#include <iostream>
#include <vector>

// other function style
int square1(int x)
{
    return x * x;
}

auto square(int x) -> int
{
    return x * x;
}

// no return
void disp(const std::string& s)
{
    std::string buf = "disp: " + s + "\n";
    printf(buf.c_str());
}

int main() {

    /*
     * comment
     */
    std::cout << "Hello, World!" << std::endl; // comment
    const int              a = square(3);
    const std::string      s = "abc";
    const std::vector<int> v = {1, 2, 3};
    std::cout << a << std::endl;
    disp("Hello World");

    int one = 1;
    int& b = one;
    b = 2;
    disp(std::to_string(one));



    return 0;
}