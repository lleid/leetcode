记录leetcode刷题记录

### 递归



奇淫巧计

```
//删除索引后的元素前移
for (int i = index + 1; i < count; i++) {
    data[i - 1] = data[i];
}     
//插入索引后的后移
for (int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
} 
```

```
//数据搬移  从head~tail 搬移到 0~tail-head
for (int i = head; i < tail; i++) {
    items[i - head] = items[i];
}

//更新head,tail
tail -= head;
head = 0;      
```
```
//循环队列入队
public boolean enqueue(String item) {
 //队列已满 (tail+1)%n ==head
 if ((tail + 1) % n == head) {
     return false;
 }

 items[tail] = item;
 tail = (tail + 1) % n;
 return true;
}
```
