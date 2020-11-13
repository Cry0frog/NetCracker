package sort.isorter;

/**
 * Sort interface, has one comparison method
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public interface ISort<T> {

    /**
     * The method compares two Contract
     * @param o1
     * @param o2
     * @return int value
     */
    int compare(T o1, T o2);
}
