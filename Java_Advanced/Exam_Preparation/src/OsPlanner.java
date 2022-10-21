import java.util.ArrayDeque;
import java.util.Scanner;

public class OsPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] taskStrings = scanner.nextLine().split(", ");

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        for (String task : taskStrings) {
            tasks.push(Integer.parseInt(task));
        }

        String[] threadStrings = scanner.nextLine().split(" ");
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        for (String thread : threadStrings) {
            threads.offer(Integer.parseInt(thread));
        }

        Integer targetTask = Integer.parseInt(scanner.nextLine());
        while(!targetTask.equals(tasks.peek())){
            int task = tasks.pop();
            int thread = threads.poll();

            if(thread < task) {
                tasks.push(task);
            }
        }
        System.out.printf("Thread with value %d killed task %d\n", threads.peekFirst(), targetTask);


        System.out.println(threads.stream()
                .map(t -> t.toString())
                .reduce((a, b) -> a + " " + b)
                .orElse(""));
    }
}