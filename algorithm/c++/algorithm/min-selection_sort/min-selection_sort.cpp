#include <iostream>

namespace A {
	void circleyes(void) {
		std::cout << "�� A�Լ���" << std::endl;
	}
}
namespace B {
	void circleyes(void) {
		std::cout << "�� B�Լ���" << std::endl;
	}
}

int main(void) {
	std::cout << "Hello world" << std::endl;
	std::cout << 2020 << 'a' << "Circle_yes" << std::endl;
	A::circleyes();
	B::circleyes();
	
	return 0;
}

