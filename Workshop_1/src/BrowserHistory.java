import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while(!line.equals("Home")) {
            if(line.equals("back")) {
                if (browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    String previousUrl = browserHistory.pop();
                    forwardPages.addFirst(previousUrl);
                }
            } else if (line.equals("forward")) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                }
                String nextUrl = forwardPages.poll();
                browserHistory.push(nextUrl);
            } else {
                browserHistory.push(line);
                forwardPages.clear();
            }

            System.out.println(browserHistory.peek());
            line = scanner.nextLine();
        }
    }
}