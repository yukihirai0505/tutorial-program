#include <iostream>
#include <vector>
#include <map>

// other function style
int square1(int x) {
    return x * x;
}

auto square(int x) -> int {
    return x * x;
}

// no return
void disp(const std::string& s) {
    std::cout << "disp: " << s << std::endl;
}

void disp_int(int s) {
    std::cout << s << std::endl;
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

    // get first
    disp(to_str(v.front()));
    // get last
    disp(to_str(v.back()));

    // cannot const
    std::vector<int> vv = {1,2,3};
    vv.push_back(4);
    disp(to_str(vv.back()));
    vv.pop_back();
    disp(to_str(vv.back()));
    vv.assign({4,5,6});
    disp(to_str(vv.back()));

    // normal
    for (int i = 0; i < v.size(); ++i) {
        disp(to_str(v[i]));
    }

    // simple
    for (const int x: v) {
        disp(to_str(x));
    }

    const std::map<std::string, int> m = {
            {"Akira", 24},
            {"Milla", 16},
            {"Johny", 38}
    };

    const int age = m.at("Akira");
    disp(to_str(age));

    std::map<std::string, int> mm = {
            {"Akira", 24},
            {"Milla", 16},
            {"Johny", 38}
    };
    mm["Sol"] = 150;
    int solAge = mm.at("Sol");
    disp(to_str(solAge));

    std::vector<int> vvv = {1,2,3,4,5,6,7,8,9,10};
    std::reverse(vvv.begin(), vvv.end());
    std::for_each(vvv.begin(), vvv.end(), &disp_int);
    auto it = std::find(vvv.begin(), vvv.end(), 2);
    if (it != v.end()) {
        std::cout << "found: " << *it << std::endl;
    } else {
        std::cout << "not found: " << std::endl;
    }

    return 0;
}