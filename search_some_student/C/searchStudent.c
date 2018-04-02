#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int count;
	int sum;           							//每个元素和其后面size个相邻元素的和 
} Node;

typedef struct {
  int capacity;
  int count;
  Node *arrays;
} Linear;

int initLinearList(Linear **head, int capacity); 
void appendValue(Linear *linear, Node value);
int getCapacity(Linear linear);
Node getMaxSumNode(Linear linear);
int computeNodeValueSum(Linear linear, int start, int count);
void injectNodeSum(Linear *linear, int size);
Node getNodeByIndex(Linear linear, int index);

Node getNodeByIndex(Linear linear, int index) {
	if (index < 0 || index > linear.count) {
		exit(0);
	}
	return linear.arrays[index];
}

void injectNodeSum(Linear *linear, int size) {
	int i = 0;
	
	while (i < linear->count) {
		linear->arrays[i].sum = computeNodeValueSum(*linear, i, size);
		i++;
	}
}

int computeNodeValueSum(Linear linear, int start, int count) {
	int sum = 0;
	int i = start;
	
	while (i < count+start) {
		if (i > linear.count-1) {
			sum += linear.arrays[i-linear.count].count;
		} else {
			sum += linear.arrays[i].count;	
		}
		i++;
	}
	
	return sum;
}

Node getMaxSumNode(Linear linear) {
	int i = 1;
	Node max = linear.arrays[0];
	
	while (i < linear.count) {
		if (max.sum < linear.arrays[i].sum) {
			max = linear.arrays[i];
		}
		i++;
	}
	return max;
}

int getCapacity(Linear linear) {
	return linear.capacity;
}

void appendValue(Linear *linear, Node value) {
	if (linear == NULL || linear->count >= linear->capacity) {
		return;	
	}
	linear->arrays[linear->count++] = value;
}

int initLinearList(Linear **head, int capacity) {
	if (*head != NULL) {
		return 0;
	}
	
	*head = (Linear*)malloc(sizeof(Linear)); 
	(*head)->arrays = (Node*)malloc(sizeof(Node)*capacity);
	(*head)->count = 0;
	(*head)->capacity = capacity;
	
	return 1;
}

/*
7
1
2
3
6
5
4
5
3
*/ 
int main(void) {
	int size = 0;
	Node node = {
		0
	};
	Linear *linear = NULL;
	int i = 0;
	
	scanf("%d", &size);                          //学生个数 
	initLinearList(&linear, size); 
	while (size-- > 0) {
		scanf("%d", &(node.count));
		appendValue(linear, node);
	}                
	scanf("%d", &size);                          //选出的学生个数 
	injectNodeSum(linear, size);                 //计算每个节点的sum 
	while (i < linear->count) {
		printf("%d:%d\n", linear->arrays[i].count, linear->arrays[i].sum);
		i++;
	}
	printf("%d", getMaxSumNode(*linear).sum);    //得到sum最大的一组数据 
	
	return 0;
}