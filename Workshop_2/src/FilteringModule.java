import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> invitationNames = Arrays.stream(scanner.nextLine().split(" ")).toList();
        String line = scanner.nextLine();

        List<BiPredicate<String, String>> filters = new ArrayList<>();
        List<String> filtersArguments = new ArrayList<>();

        BiPredicate<String, String> startsWith = (str, prefix) -> str.startsWith(prefix);
        BiPredicate<String, String> endsWith = (str, suffix) -> str.endsWith(suffix);
        BiPredicate<String, String> length = (str, len) -> str.length() == Integer.parseInt(len);
        BiPredicate<String, String> contains = (str, substring) -> str.contains(substring);

        HashMap<String, BiPredicate<String, String>> translationMap = new HashMap<>();
        translationMap.put("Starts with", startsWith);
        translationMap.put("Ends with", endsWith);
        translationMap.put("Length", length);
        translationMap.put("Contains", contains);

        while(!line.equals("Print")) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            String filterArgument = tokens[2];

            if(command.equals("Add filter")) {
                filters.add(translationMap.get(filterType));
                filtersArguments.add(filterArgument);
            } else if (command.equals("Remove filter")) {
                for (int i = 0; i < filters.size(); i++) {
                    if (getFirstKeyFromValue(filters.get(i), translationMap).equals(filterType) &&
                            filtersArguments.get(i).equals(filterArgument)) {
                        filters.remove(i);
                        filtersArguments.remove(i);
                    }
                }
            }

            line = scanner.nextLine();
        }

        for (int i = 0; i < filters.size(); i++) {
            invitationNames = invitationNames.stream()
                    .filter(applyNthFilter(filters, filtersArguments, i))
                    .collect(Collectors.toList());
        }

        System.out.println(String.join(" ", invitationNames));
    }

    static Predicate<String> applyNthFilter(List<BiPredicate<String, String>> filters, List<String> arguments, int currentIndex) {
        return name -> !filters.get(currentIndex).test(name, arguments.get(currentIndex));
    }

    static String getFirstKeyFromValue(BiPredicate<String, String> value, Map<String, BiPredicate<String, String>> map) {
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == value)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse("");
    }
}
