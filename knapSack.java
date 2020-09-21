/*
Given a list of items with values and weights, as well as a max weight, find the maximum value you can generate from items where the sum of the weights is less than the max.

items = {(w:1, v:6), (w:2, v:10), (w:3, v:12)}
maxWeight = 5
knapsack(items, maxWeight) = 22

items = {(w:1, v:6), (w:2, v:10), (w:3, v:12)}
maxWeight = 5
knapsack(items, maxWeight) = 22
*/


// Recursive solution that uses a cache to improve performance
public static int topDownKnapsack(Item[] items, int W) {
    // Map: i -> W -> value
    // Use a map instead of array because the data could be very sparse
    Map<Integer, Map<Integer, Integer>> cache = new HashMap<Integer, Map<Integer, Integer>>();
    return topDownKnapsack(items, W, 0, cache);
}
    
// Overloaded recursive function for topDownKnapsack
private static int topDownKnapsack(Item[] items, int W, int i, Map<Integer, Map<Integer, Integer>> cache) {
    // Return when we reach the end of the list
    if (i == items.length) return 0;
        
    // Check the cache and return value if we get a hit
    if (!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());
    Integer cached = cache.get(i).get(W);
    if (cached != null) return cached;
        
    // If item is heavier than remaining weight, skip item
    if (W - items[i].weight < 0) return topDownKnapsack(items, W, i+1, cache);
     
    // Try both including and excluding the current item
    int toReturn = Math.max(topDownKnapsack(items, W - items[i].weight, i+1, cache) + items[i].value,
                            topDownKnapsack(items, W, i+1, cache));
    cache.get(i).put(W, toReturn);
    return toReturn;
}
