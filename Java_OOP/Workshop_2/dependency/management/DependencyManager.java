package dependency.management;

public class DependencyManager {
    public void wireDependencies() {
        //Scan the classpath
        //Filter only the classes who have @Dependency annotation
        //Iterate over the classes
        //  * get the constructor using reflection
        //  * resolve argument types
        //  * search 1 type and resolve recursively

        // A depends on B, B depends on A
    }
}
