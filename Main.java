public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(-10);

        for (Integer item : queue) {
            System.out.print(item + " ");
        }

        System.out.println();

        Integer deqItem = queue.dequeue();
        System.out.println("Item dequeued = " + deqItem);

        deqItem = queue.dequeue();
        System.out.println("Item dequeued = " + deqItem);

        for (Integer item : queue) {
            System.out.print(item + " ");
        }

        System.out.println("\n" + "First item = " + queue.getFirst());
        System.out.println("Last item = " + queue.getLast());
    }
}
