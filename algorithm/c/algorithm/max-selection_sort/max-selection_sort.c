#include <stdio.h>

int main() {

	int array[] = { 5, 2, 4, 6, 1, 3 };

	for (int i = 0; i < (sizeof(array) / sizeof(int)); i++) {
		printf("%d ", array[i]);
	}
	printf("\n");

	int array_size = sizeof(array) / sizeof(int);

	MaxSelectArrayInt(array, array_size);


	for (int i = 0; i < (sizeof(array) / sizeof(int)); i++) {
		printf("%d ", array[i]);
	}
	printf("����");

	return 0;
}

int MaxSelectArrayInt(int array[], int array_size) {
	int max_num, max_num_index;
	int temp;

	int another_index;

	for (int insert_index = 0; insert_index < array_size - 1; insert_index++) {
		max_num = array[insert_index];
		max_num_index = insert_index;

		for (another_index = insert_index; another_index < array_size; another_index++) {
			if (max_num < array[another_index]) {
				max_num = array[another_index];
				max_num_index = another_index;
			}
		}
		printf("%d�� �ε��� ������ �ִ밪 %d�� �ε��� %d�� �̴�.\n", insert_index, max_num, max_num_index);
		printf("%d�� �ε��� ���� %d�� �ε��� �� ��ȯ\n", insert_index, max_num_index);


		temp = array[insert_index];
		array[insert_index] = array[max_num_index];
		array[max_num_index] = temp;

		for (int i = 0; i < array_size; i++) {
			printf("%d ", array[i]);
		}
		printf("%d��° ���� \n", insert_index + 1);
	}

	return 0;

}


