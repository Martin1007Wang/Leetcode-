public class Main {
    public static void main(String[] args) {
        FixedSizeQueue queue = new FixedSizeQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 输出：1
        System.out.println(queue.dequeue()); // 输出：2

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue()); // 输出：3
        System.out.println(queue.dequeue()); // 输出：4
        System.out.println(queue.dequeue()); // 输出：5

        System.out.println(queue.dequeue()); // 输出：队列为空，无法取出元素！-1
    }
}
